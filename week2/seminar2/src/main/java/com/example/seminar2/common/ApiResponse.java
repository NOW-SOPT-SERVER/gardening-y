package com.example.seminar2.common;

import com.example.seminar2.common.exception.ErrorStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ApiResponse<T> {
    private final int status;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public static ApiResponse<?> of(SuccessStatus successStatus) {
        return builder()
                .status(successStatus.getHttpStatus().value())
                .message(successStatus.getMessage())
                .build();
    }

    public static <T> ApiResponse<?> of(SuccessStatus successStatus, T data) {
        return builder()
                .status(successStatus.getHttpStatus().value())
                .message(successStatus.getMessage())
                .data(data)
                .build();
    }

    public static ApiResponse<?> of(ErrorStatus errorStatus) {
        return builder()
                .status(errorStatus.getHttpStatus().value())
                .message(errorStatus.getMessage())
                .build();
    }

    public static ResponseEntity<ApiResponse<?>> success(SuccessStatus successStatus) {
        return ResponseEntity.status(successStatus.getHttpStatus())
                .body(ApiResponse.of(successStatus));
    }

    public static <T> ResponseEntity<ApiResponse<?>> success(SuccessStatus successStatus, T data) {
        return ResponseEntity.status(successStatus.getHttpStatus())
                .body(ApiResponse.of(successStatus, data));
    }

    public static ResponseEntity<ApiResponse<?>> error(ErrorStatus errorStatus) {
        return ResponseEntity.status(errorStatus.getHttpStatus())
                .body(ApiResponse.of(errorStatus));
    }
}
