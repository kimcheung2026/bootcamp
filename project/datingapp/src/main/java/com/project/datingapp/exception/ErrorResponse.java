package com.project.datingapp.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
  private int code; // 自定義錯誤碼 (如 40001)
  private String message; // 給前端看的錯誤訊息
  private LocalDateTime timestamp; // 錯誤發生的時間 (選配，方便排錯)

  // 快速建立物件的便利建構子
  public ErrorResponse(int code, String message) {
    this.code = code;
    this.message = message;
    this.timestamp = LocalDateTime.now();
  }
}
