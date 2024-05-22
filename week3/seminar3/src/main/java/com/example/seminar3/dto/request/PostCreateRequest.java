package com.example.seminar3.dto.request;

import jakarta.validation.constraints.NotBlank;

public record PostCreateRequest(
        @NotBlank(message = "제목 입력은 필수 입력입니다.")
        String title,
        String content
) {
}
