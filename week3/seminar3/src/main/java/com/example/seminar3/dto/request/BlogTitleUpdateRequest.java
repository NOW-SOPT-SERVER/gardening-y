package com.example.seminar3.dto.request;

import jakarta.validation.constraints.Size;

public record BlogTitleUpdateRequest(
        @Size(max = 5 , message = "블로그 제목이 최대 글자 수(5자)를 초과했습니다.")
        String title
) {
}
