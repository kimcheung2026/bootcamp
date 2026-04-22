package com.project.datingapp.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class MerchantException extends RuntimeException {
    private final int code;
    private final HttpStatus status;

    // 1. 最常用的構造函數：直接傳入 ENUM
    public MerchantException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.status = errorCode.getStatus();
    }

    // 2. 支援傳入 ENUM 但「自定義訊息」（例如想在訊息裡加入變數）
    public MerchantException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
        this.status = errorCode.getStatus();
    }

    // 3. 保留一個純字串的構造函數（可選，用於快速開發或臨時異常）
    public MerchantException(String message) {
        super(message);
        this.code = 400; // 預設通用錯誤碼
        this.status = HttpStatus.BAD_REQUEST;
    }
}
