package org.example.service;

import org.example.common.CustomException;
import org.example.common.ErrorMessage;
import org.example.domain.Account;
import org.example.domain.Customer;
import org.example.domain.common.AccountType;
import org.example.dto.AccountSecurityDTO;
import org.example.dto.CreateAccountDTO;
import org.example.dto.CreateCustomerDTO;
import org.example.dto.DepositDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SavingsAccountService implements AccountService {

    private static List<Account> accounts = new ArrayList<>();
    private final CustomerService customerService;
    private static final int ACCOUNT_NUMBER = 9;


    public SavingsAccountService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Account createAccount(CreateAccountDTO createAccountDTO) {
        CreateCustomerDTO dto = CreateCustomerDTO.of(createAccountDTO.person(), createAccountDTO.bank());
        Customer customer = customerService.createCustomer(dto);
        long accountId = createAccountId(ACCOUNT_NUMBER);
        Account account = Account.createAccount(accountId, customer, createAccountDTO.password(), AccountType.SAVINGS);
        accounts.add(account);
        return account;
    }

    @Override
    public long deposit(DepositDTO depositDTO) {
        Account account = findAccountById(depositDTO.accountId());
        validateAccountPassword(account, depositDTO.password());
        account.setBalance(account.getBalance() + depositDTO.amount());
        return account.getBalance();
    }

    @Override
    public long getBalance(AccountSecurityDTO accountSecurityDTO) {
        Account account = findAccountById(accountSecurityDTO.accountId());
        validateAccountPassword(account, accountSecurityDTO.password());
        return account.getBalance();
    }

    @Override
    public void deleteAccount(AccountSecurityDTO accountSecurityDTO) {
        Account account = findAccountById(accountSecurityDTO.accountId());
        validateAccountPassword(account, accountSecurityDTO.password());
        accounts.remove(account);
    }

    private long createAccountId(int len) {
        long min = (long) Math.pow(10, len - 1);
        long max = (long) Math.pow(10, len) - 1;

        long randomId = ThreadLocalRandom.current().nextLong(min, max+1);

        return Long.parseLong("2" + randomId);
    }

    private Account findAccountById(long accountId) {
        for (Account account : accounts) {
            if (account.getAccountId() == accountId) {
                return account;
            }
        }
        throw new CustomException(ErrorMessage.NOT_FOUND_ACCOUNT);
    }

    private void validateAccountPassword(Account account, long password) {
        if (account.getPassword()!= password) {
            throw new CustomException(ErrorMessage.INVALID_ACCOUNT_PASSWORD);
        }
    }
}
