package org.example.dto;

public record TransferDTO(
        long accountId,
        long password,
        long balance,
        long sendAccountId
) {
    public static TransferDTO of(long accountId, long password, long balance, long sendAccountId) {
        return new TransferDTO(accountId, password, balance, sendAccountId);
    }
}
