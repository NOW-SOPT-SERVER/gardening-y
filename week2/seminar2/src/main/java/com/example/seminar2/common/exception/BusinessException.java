package com.example.seminar2.common.exception;

public class BusinessException extends RuntimeException{
    public final ErrorStatus errorStatus;

    public BusinessException(ErrorStatus errorStatus) {
        super(errorStatus.getMessage());
        this.errorStatus = errorStatus;
    }
}
