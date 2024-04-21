package com.example.seminar2.dto.response;

import com.example.seminar2.domain.Member;
import lombok.AccessLevel;
import lombok.Builder;

import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record MembersFindResponse(
        List<Member> members
) {
    public static MembersFindResponse of(List<Member> members) {
        return MembersFindResponse.builder()
               .members(members)
               .build();
    }
}
