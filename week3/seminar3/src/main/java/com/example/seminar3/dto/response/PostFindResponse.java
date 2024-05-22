package com.example.seminar3.dto.response;

import com.example.seminar3.domain.Post;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record PostFindResponse(
        String title,
        String content
) {

    public static PostFindResponse of(Post post) {
        return PostFindResponse.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }
}
