package com.project.datingapp.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
  private int code; // 自定義錯誤碼 (如 40001)
  private String message; // 給前端看的錯誤訊息
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 固定 JSON 輸出的時間格式
  private LocalDateTime timestamp;

  // 快速建立物件的便利建構子
  public ErrorResponse(int code, String message) {
    this.code = code;
    this.message = message;
    this.timestamp = LocalDateTime.now();
  }
}
