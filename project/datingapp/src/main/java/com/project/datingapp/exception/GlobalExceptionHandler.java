package com.project.datingapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j // Error LOG
@RestControllerAdvice
public class GlobalExceptionHandler {

  // 1. 處理用戶業務異常 (統一回傳 ErrorResponse)
  @ExceptionHandler(UserServiceException.class)
  public ResponseEntity<ErrorResponse> handleUserServiceException(UserServiceException e, HttpServletRequest request) {
    log.warn("用戶業務異常 [{}]: {}, Path: {}", e.getCode(), e.getMessage(), request.getRequestURI());

    return ResponseEntity.status(e.getStatus()) // 這裡括號先結束
        .body(new ErrorResponse(e.getCode(), e.getMessage()));
  }

  // 2. 處理商家業務異常
  @ExceptionHandler(MerchantException.class)
  public ResponseEntity<ErrorResponse> handleMerchantException(MerchantException e, HttpServletRequest request) {
    log.warn("商家業務異常 [{}]: {}, Path: {}", e.getCode(), e.getMessage(), request.getRequestURI());

    return ResponseEntity.status(e.getStatus())
        .body(new ErrorResponse(e.getCode(), e.getMessage()));
  }

  // 3. 處理所有未預期的系統錯誤 (如 NPE, SQL 報錯)
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleSystemException(Exception e, HttpServletRequest request) {
    // 記錄錯誤細節與堆疊資訊 (Stack Trace)
    log.error("未預期的系統錯誤! Path: {}, Message: {}", request.getRequestURI(), e.getMessage(), e);

    // 對外隱藏敏感資訊，只給 500 錯誤碼
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new ErrorResponse(ErrorCode.SYSTEM_ERROR.getCode(), "伺服器內部錯誤，請稍後再試"));
  }
}