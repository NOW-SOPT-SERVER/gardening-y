package com.example.seminar3.dto.response;

import com.example.seminar3.domain.Post;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record PostCreateResponse(
        Long id
) {

    public static PostCreateResponse of(Post post) {
        return PostCreateResponse.builder()
                .id(post.getId())
                .build();
    }
}
