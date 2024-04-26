package com.example.seminar3.common;

import com.example.seminar3.common.exception.BusinessException;
import com.example.seminar3.common.exception.ErrorStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<?>> handleBusinessException(BusinessException e) {
        log.error(">>> handle: BusinessException ", e);
        return ApiResponse.error(e.errorStatus);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleException(Exception e) {
        log.error(">>> handle: Exception ", e);
        return ApiResponse.error(ErrorStatus.INTERNAL_SERVER_ERROR);
    }
}
