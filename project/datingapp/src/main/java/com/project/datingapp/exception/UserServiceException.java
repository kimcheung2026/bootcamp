package com.project.datingapp.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class UserServiceException extends RuntimeException {
    private final int code; // 新增 code 欄位

    @NonNull
    private final HttpStatus status;

    // 1. 核心構造函數：對接 ErrorCode ENUM
    public UserServiceException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.status = errorCode.getStatus();
    }

    // 2. 支援自定義訊息（保留 ENUM 的 code 與 status）
    public UserServiceException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
        this.status = errorCode.getStatus();
    }

    // 3. 為了相容舊代碼（可選，預設 400 錯誤）
    public UserServiceException(String message) {
        super(message);
        this.code = 400;
        this.status = HttpStatus.BAD_REQUEST;
    }
}