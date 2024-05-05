package com.example.carrot.common;

import com.example.carrot.common.exception.ErrorStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class BaseResponse<T> {
    private final int status;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    private static BaseResponse<?> of(SuccessStatus successStatus) {
        return builder()
                .status(successStatus.getHttpStatus().value())
                .message(successStatus.getMessage())
                .build();
    }

    private static <T> BaseResponse<?> of(SuccessStatus successStatus, T data) {
        return builder()
                .status(successStatus.getHttpStatus().value())
                .message(successStatus.getMessage())
                .data(data)
                .build();
    }

    private static BaseResponse<?> of(ErrorStatus errorStatus) {
        return builder()
                .status(errorStatus.getHttpStatus().value())
                .message(errorStatus.getMessage())
                .build();
    }

    public static ResponseEntity<BaseResponse<?>> success(SuccessStatus successStatus) {
        return ResponseEntity.status(successStatus.getHttpStatus())
                .body(BaseResponse.of(successStatus));
    }

    public static <T> ResponseEntity<BaseResponse<?>> success(SuccessStatus successStatus, T data) {
        return ResponseEntity.status(successStatus.getHttpStatus())
                .body(BaseResponse.of(successStatus, data));
    }

    public static ResponseEntity<BaseResponse<?>> error(ErrorStatus errorStatus) {
        return ResponseEntity.status(errorStatus.getHttpStatus())
                .body(BaseResponse.of(errorStatus));
    }
}
