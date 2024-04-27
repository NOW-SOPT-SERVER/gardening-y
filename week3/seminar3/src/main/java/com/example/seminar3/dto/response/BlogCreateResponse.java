package com.example.seminar3.dto.response;

import com.example.seminar3.domain.Blog;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record BlogCreateResponse(
    Long id
) {

    public static BlogCreateResponse of(Blog blog) {
        return BlogCreateResponse.builder()
               .id(blog.getId())
               .build();
    }
}
