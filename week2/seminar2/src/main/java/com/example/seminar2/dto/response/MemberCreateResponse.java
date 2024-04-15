package com.example.seminar2.dto.response;

import com.example.seminar2.domain.Member;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record MemberCreateResponse(
        Long id
) {
    public static MemberCreateResponse of(Member member) {
        return MemberCreateResponse.builder()
               .id(member.getId())
               .build();
    }
}
