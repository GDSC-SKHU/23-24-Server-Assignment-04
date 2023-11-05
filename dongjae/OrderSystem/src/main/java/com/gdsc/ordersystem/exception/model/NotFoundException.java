package com.gdsc.ordersystem.exception.model;

import com.gdsc.ordersystem.exception.ErrorCode;

public class NotFoundException extends CustomException {
    public NotFoundException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}