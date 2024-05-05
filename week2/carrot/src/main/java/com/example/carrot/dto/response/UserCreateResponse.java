package com.example.carrot.dto.response;

import com.example.carrot.domain.User;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record UserCreateResponse(
        Long id,
        String name
) {
    public static UserCreateResponse of(User user) {
        return builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }
}
