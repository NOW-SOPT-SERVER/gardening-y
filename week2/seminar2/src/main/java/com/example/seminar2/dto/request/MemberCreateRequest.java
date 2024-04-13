package com.example.seminar2.dto.request;

import com.example.seminar2.domain.Part;

public record MemberCreateRequest(
        String name,
        Part part,
        int age
) {
}