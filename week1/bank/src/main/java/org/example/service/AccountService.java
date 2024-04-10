package org.example.service;

import org.example.domain.Account;
import org.example.dto.AccountSecurityDTO;
import org.example.dto.CreateAccountDTO;
import org.example.dto.DepositDTO;

public interface AccountService {
    Account createAccount(CreateAccountDTO createAccountDTO); // 계좌 개설
    long deposit(DepositDTO depositDTO); // 입금
    long getBalance(AccountSecurityDTO accountSecurityDTO); // 잔액 조회
    void deleteAccount(AccountSecurityDTO accountSecurityDTO); // 계좌 해지
}
