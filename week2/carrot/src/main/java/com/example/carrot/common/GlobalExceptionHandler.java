package com.example.carrot.common;

import com.example.carrot.common.exception.BusinessException;
import com.example.carrot.common.exception.ErrorStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<BaseResponse<?>> handleBusinessException(BusinessException e) {
        log.error(">>> handle: BusinessException ", e);
        return BaseResponse.error(e.errorStatus);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse<?>> handleException(Exception e) {
        log.error(">>> handle: Exception ", e);
        return BaseResponse.error(ErrorStatus.INTERNAL_SERVER_ERROR);
    }
}
