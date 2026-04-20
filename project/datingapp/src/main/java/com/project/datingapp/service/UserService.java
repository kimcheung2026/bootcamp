package com.project.datingapp.service;

import java.time.LocalDate;
import java.time.Period;

import com.project.datingapp.entity.User;
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

  // 1. 用戶註冊失敗的報錯處理
  public User registerUser(User user) {
    // 檢查帳號是否已存在
    if (userRepository.existsByUsername(user.getUsername())) {
      throw new UserServiceException("註冊失敗：帳號 [" + user.getUsername() + "] 已被佔用");
    }

    // 檢查信箱是否重複
    if (userRepository.existsByEmail(user.getEmail())) {
      throw new UserServiceException("註冊失敗：信箱 [" + user.getEmail() + "] 已被註冊");
    }
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }

  // 2. 年齡計算與邏輯檢查的報錯處理
  public int calculateUserAge(User user) {
    LocalDate birthday = user.getBirthday();

    // 檢查生日是否為空
    if (birthday == null) {
      throw new UserServiceException("年齡計算失敗：用戶尚未設定生日");
    }

    // 檢查生日是否在未來（邏輯錯誤）
    if (birthday.isAfter(LocalDate.now())) {
      throw new UserServiceException("年齡計算失敗：生日不能是未來的日期");
    }

    return Period.between(birthday, LocalDate.now()).getYears();
  }
}
