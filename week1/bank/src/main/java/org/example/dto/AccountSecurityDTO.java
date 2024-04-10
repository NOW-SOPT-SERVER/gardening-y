package org.example.dto;

public record AccountSecurityDTO(
        long accountId,
        long password
) {

    public static AccountSecurityDTO of(long accountId, long password) {
        return new AccountSecurityDTO(accountId, password);
    }
}
