package com.example.seminar3.common.exception;

public class BusinessException extends RuntimeException{
    public final ErrorStatus errorStatus;

    public BusinessException(ErrorStatus errorStatus) {
        super(errorStatus.getMessage());
        this.errorStatus = errorStatus;
    }
}
