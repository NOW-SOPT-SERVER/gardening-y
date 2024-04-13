package org.example.dto;

public record DepositDTO(
        long accountId,
        long password,
        long amount
) {
    public static DepositDTO of(long accountId, long password, long amount) {
        return new DepositDTO(accountId, password, amount);
    }
}
