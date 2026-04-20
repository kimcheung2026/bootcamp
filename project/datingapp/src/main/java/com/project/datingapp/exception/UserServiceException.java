package com.project.datingapp.exception;

// 繼承 RuntimeException 既符合開發規範也方便事務回滾
public class UserServiceException extends RuntimeException {
    public UserServiceException(String message) {
        super(message);
    }
}