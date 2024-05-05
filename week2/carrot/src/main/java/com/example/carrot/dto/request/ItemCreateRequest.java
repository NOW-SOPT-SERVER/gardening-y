package com.example.carrot.dto.request;

public record ItemCreateRequest(
        Long userId,
        String title,
        int price,
        boolean suggestion,
        String description,
        String category,
        String local
) {
}
