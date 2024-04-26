package com.example.seminar3.dto.request;

import com.example.seminar3.domain.Part;

public record MemberCreateRequest(
        String name,
        Part part,
        int age
) {
}