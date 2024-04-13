package org.example.dto;

public record WithdrawDTO(
        long accountId,
        long password,
        long balance
) {
    public static WithdrawDTO of(long accountId, long password, long balance) {
        return new WithdrawDTO(accountId, password, balance);
    }
}