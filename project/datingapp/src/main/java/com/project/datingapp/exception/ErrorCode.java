package com.project.datingapp.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ErrorCode {

  // --- 通用錯誤 ---
  SYSTEM_ERROR(500, "System error occurred", HttpStatus.INTERNAL_SERVER_ERROR),
  INVALID_PARAMETER(400, "Invalid parameter format", HttpStatus.BAD_REQUEST),

  // --- 商家相關 (400xx) ---
  MERCHANT_ALREADY_EXISTS(40001, "Username already exists", HttpStatus.BAD_REQUEST),
  BRN_ALREADY_EXISTS(40002, "This BRN is already registered", HttpStatus.BAD_REQUEST),
  EMAIL_ALREADY_EXISTS(40003, "This email is already registered", HttpStatus.BAD_REQUEST),
  BRN_FORMAT_ERROR(40010, "Invalid BRN format", HttpStatus.BAD_REQUEST),
  MERCHANT_NOT_FOUND(40404, "Merchant not found", HttpStatus.NOT_FOUND),
  MERCHANT_NOT_VERIFIED(40301, "Merchant account not verified", HttpStatus.FORBIDDEN),
  AUTH_FAILED(40401, "Invalid username or password", HttpStatus.UNAUTHORIZED),

  // --- 用戶相關 (410xx) ---
  USER_ALREADY_EXISTS(41001, "User account already exists", HttpStatus.BAD_REQUEST),
  USER_NOT_FOUND(41002, "User not found", HttpStatus.NOT_FOUND),
  BIRTHDAY_INVALID(41003, "Invalid birthday date", HttpStatus.BAD_REQUEST),
  INVALID_ROLE(41004, "Invalid role", HttpStatus.BAD_REQUEST);

  private final int code;
  private final String message;
  private final HttpStatus status;

  ErrorCode(int code, String message, HttpStatus status) {
    this.code = code;
    this.message = message;
    this.status = status;
  }
}
