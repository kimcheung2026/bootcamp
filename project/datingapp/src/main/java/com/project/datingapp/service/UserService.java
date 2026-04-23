package com.project.datingapp.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

import com.project.datingapp.dto.UserRegisterDTO;
import com.project.datingapp.entity.User;
import com.project.datingapp.exception.ErrorCode;
import com.project.datingapp.exception.UserServiceException;
import com.project.datingapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  // 現在接收的是 DTO
  public void registerUser(UserRegisterDTO dto) throws IOException {
    // 1. 檢查帳號是否重複
    if (userRepository.existsByUsername(dto.getUsername())) {
      throw new UserServiceException("帳號已存在");
    }

    // 2. 建立 Entity 並搬運資料 (這就是你原本在 Controller 的長代碼)
    User user = new User();
    user.setUsername(dto.getUsername());
    user.setPassword(passwordEncoder.encode(dto.getPassword())); // 在 Service 加密
    user.setNickname(dto.getNickname());
    user.setGender(dto.getGender());
    user.setBirthday(dto.getBirthday());
    user.setEmail(dto.getEmail());
    user.setPhone(dto.getPhone());
    user.setIntro(dto.getIntro());

    // 3. 處理頭像檔案
    MultipartFile file = dto.getAvatarFile();
    if (file != null && !file.isEmpty()) {
      String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
      String uploadDir = System.getProperty("user.dir") + "/uploads/";
      File dest = new File(uploadDir + fileName);
      if (!dest.getParentFile().exists())
        dest.getParentFile().mkdirs();

      file.transferTo(dest);
      user.setAvatar("/uploads/" + fileName);
    }

    // 4. 存檔
    userRepository.save(user);
  }

  // 1. 用戶註冊 (使用 ErrorCode)
  public User registerUser(User user) {
    // 檢查帳號是否已存在
    if (userRepository.existsByUsername(user.getUsername())) {
      throw new UserServiceException(ErrorCode.USER_ALREADY_EXISTS,
          "註冊失敗：帳號 [" + user.getUsername() + "] 已被佔用");
    }

    // 檢查信箱是否重複
    if (userRepository.existsByEmail(user.getEmail())) {
      throw new UserServiceException(ErrorCode.EMAIL_ALREADY_EXISTS);
    }

    user.setPassword(passwordEncoder.encode(user.getPassword()));
    // 直接用 User 接收，或者直接 return
    User savedUser = userRepository.save(user);
    return savedUser;
  }

  // 2. 年齡計算 (使用 ErrorCode)
  public int calculateUserAge(User user) {
    LocalDate birthday = user.getBirthday();

    if (birthday == null) {
      throw new UserServiceException(ErrorCode.BIRTHDAY_INVALID, "年齡計算失敗：用戶尚未設定生日");
    }

    if (birthday.isAfter(LocalDate.now())) {
      throw new UserServiceException(ErrorCode.BIRTHDAY_INVALID, "年齡計算失敗：生日不能是未來的日期");
    }

    return Period.between(birthday, LocalDate.now()).getYears();
  }
}