package org.example.dto;

public record CustomerInfoDTO(
        long customerId
) {
    public static CustomerInfoDTO of(long customerId) {
        return new CustomerInfoDTO(customerId);
    }
}
