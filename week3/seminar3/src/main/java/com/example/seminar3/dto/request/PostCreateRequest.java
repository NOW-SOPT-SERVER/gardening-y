package com.example.seminar3.dto.request;

import com.example.seminar3.domain.Blog;

public record PostCreateRequest(
        String title,
        String content,
        Blog blog
) {
}
