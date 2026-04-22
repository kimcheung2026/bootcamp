package com.project.datingapp.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ErrorCode {

  // --- 通用錯誤 ---
  SYSTEM_ERROR(500, "系統發生未預期錯誤", HttpStatus.INTERNAL_SERVER_ERROR),
  INVALID_PARAMETER(400, "參數格式錯誤", HttpStatus.BAD_REQUEST),

  // --- 商家相關 (400xx) ---
  MERCHANT_ALREADY_EXISTS(40001, "帳號名稱已存在", HttpStatus.BAD_REQUEST),
  BRN_ALREADY_EXISTS(40002, "此商業登記證 (BRN) 已被登記", HttpStatus.BAD_REQUEST),
  EMAIL_ALREADY_EXISTS(40003, "此電子郵件已被登記", HttpStatus.BAD_REQUEST),
  BRN_FORMAT_ERROR(40010, "BRN 格式不正確", HttpStatus.BAD_REQUEST),
  MERCHANT_NOT_FOUND(40401, "找不到該商家資訊", HttpStatus.NOT_FOUND),
  MERCHANT_NOT_VERIFIED(40301, "商家帳號尚未通過審核", HttpStatus.FORBIDDEN),

  // --- 用戶相關 (410xx) ---
  USER_ALREADY_EXISTS(41001, "用戶帳號已存在", HttpStatus.BAD_REQUEST),
  USER_NOT_FOUND(41002, "找不到該用戶", HttpStatus.NOT_FOUND),
  BIRTHDAY_INVALID(41003, "生日日期無效", HttpStatus.BAD_REQUEST);

  private final int code;
  private final String message;
  private final HttpStatus status;

  ErrorCode(int code, String message, HttpStatus status) {
    this.code = code;
    this.message = message;
    this.status = status;
  }
}
