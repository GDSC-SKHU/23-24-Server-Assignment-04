package com.gdsc.ordersystem.exception.model;

import com.gdsc.ordersystem.exception.ErrorCode;

public class BadRequestException extends CustomException {
    public BadRequestException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}
