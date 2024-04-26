package com.example.seminar3.dto.response;

import com.example.seminar3.domain.Member;
import com.example.seminar3.domain.Part;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record MemberFindResponse(
        String name,
        Part part,
        int age
) {
    public static MemberFindResponse of(Member member) {
        return MemberFindResponse.builder()
                .name(member.getName())
                .part(member.getPart())
                .age(member.getAge())
                .build();
    }
}
