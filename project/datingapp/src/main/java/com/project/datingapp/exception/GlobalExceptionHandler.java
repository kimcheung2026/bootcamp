package com.project.datingapp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(UserServiceException.class)
  public ResponseEntity<String> handleUserServiceException(UserServiceException e) {
    // 回傳 400 Bad Request 和 錯誤訊息
    return ResponseEntity.status(400).body(e.getMessage());
  }
}
