package com.example.web_tuyen_dung.util;

public class AppException extends RuntimeException {
    public AppException(String message) {
        super(message);
    }

    public AppException(Throwable cause) {
        super(cause);
    }

}
