package org.example.domain;

import org.example.domain.common.AccountType;
import org.example.domain.common.BaseTime;

import java.time.Duration;
import java.time.LocalDateTime;

public class Account extends BaseTime {

    private final long accountId;
    private final Customer customer;
    private final AccountType accountType;
    private long password;
    private long balance;
    private float rate;

    public Account(long accountId, Customer customer, long password, AccountType accountType) {
        super();
        this.accountId = accountId;
        this.customer = customer;
        this.password = password;
        this.balance = 0L;
        this.accountType = accountType;
        this.rate = calculateRate(accountType);
    }

    public static Account createAccount(long accountId, Customer customer, long password, AccountType accountType) {
        return new Account(accountId, customer, password, accountType);
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public float getRate() {
        return rate;
    }

    public long getAccountId() {
        return accountId;
    }

    public long getPassword() {
        return password;
    }

    public long getBalance() {
        long period = calculatePeriod();
        float interest = balance * rate / 100 * period / 365;
        return balance + (long) interest;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    private float calculateRate(AccountType accountType) {
        if (accountType == AccountType.SAVINGS) {
            return 2.1f;
        }
        else {
            return 0.00f;
        }
    }

    private long calculatePeriod() {
        LocalDateTime currentDate = LocalDateTime.now();
        Duration duration = Duration.between(getCreatedDate(), currentDate);
        return duration.toDays();
    }
}
