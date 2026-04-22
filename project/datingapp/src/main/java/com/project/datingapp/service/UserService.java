package com.project.datingapp.service;

import java.time.LocalDate;
import java.time.Period;

import com.project.datingapp.entity.User;
import com.project.datingapp.exception.ErrorCode;
import com.project.datingapp.exception.UserServiceException;
import com.project.datingapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

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