package org.example.menu;

import org.example.common.CustomException;
import org.example.common.ErrorMessage;
import org.example.domain.*;
import org.example.domain.common.AccountType;
import org.example.dto.*;
import org.example.service.AccountService;
import org.example.service.CheckingAccountService;
import org.example.service.CustomerService;
import org.example.service.SavingsAccountService;

import java.util.Scanner;

public class Menu {
    private final CustomerService customerService;
    private final CheckingAccountService checkingAccountService;
    private final SavingsAccountService savingsAccountService;
    private final Scanner sc = new Scanner(System.in);

    public Menu(CustomerService customerService, CheckingAccountService checkingAccountService, SavingsAccountService savingsAccountService) {
        this.customerService = customerService;
        this.checkingAccountService = checkingAccountService;
        this.savingsAccountService = savingsAccountService;
    }

    public void startMenu(Person person) {
        int menuNum;

        do {
            System.out.println("무엇을 도와드릴까요?");
            System.out.println("1. 회원 가입");
            System.out.println("2. 회원 정보 확인");
            System.out.println("3. 계좌 생성");
            System.out.println("4. 입금");
            System.out.println("5. 출금");
            System.out.println("6. 이체");
            System.out.println("7. 계좌 잔고 조회");
            System.out.println("8. 계좌 해지");
            System.out.println("9. 적금 확인");
            System.out.println("0. 종료");
            menuNum = sc.nextInt();
            run(menuNum, person);
        }while (menuNum != 0);
    }

    private void run(int menuNum, Person person) {
        switch (menuNum) {
            case 0 -> System.out.println("종료합니다.");
            case 1 -> createCustomer(person);
            case 2 -> getCustomer();
            case 3 -> createAccount(person);
            case 4 -> deposit();
            case 5 -> withdraw();
            case 6 -> transfer();
            case 7 -> getBalance();
            case 8 -> deleteAccount();
            case 9 -> getSavingBalance();
            default -> System.out.println("잘못된 번호가 입력되었습니다.");
        }
    }

    private void createCustomer(Person person) {
        System.out.println("회원가입이 진행됩니다.");
        int bankNum = inputBankNum();
        Bank bank = choiceBank(bankNum);
        Customer customer = customerService.createCustomer(CreateCustomerDTO.of(person, bank));
        printSuccess();
        printCustomer(customer);
    }

    private void getCustomer() {
        System.out.println("회원정보 확인 서비스입니다.");
        long customerId = inputCustomerId();
        Customer foundCustomer = customerService.getCustomer(CustomerInfoDTO.of(customerId));
        printCustomer(foundCustomer);
    }

    private void createAccount(Person person) {
        System.out.println("계좌 생성 서비스입니다.");
        int accountType = inputAccountType();
        long password = inputPassword();
        AccountService accountService = (accountType == 1) ? checkingAccountService : savingsAccountService;
        Account account = accountService.createAccount(CreateAccountDTO.of(person, Bank.SOPT, password));
        printSuccess();
        printAccount(account);
    }

    private void deposit() {
        System.out.println("입금 서비스입니다.");
        long accountId = inputAccountId();
        long password = inputPassword();
        long money = inputMoney();
        long resultBalance = checkingAccountService.deposit(DepositDTO.of(accountId, password, money));
        printSuccess(resultBalance);
    }

    private void withdraw() {
        System.out.println("출금 서비스입니다.");
        long accountId = inputAccountId();
        long password = inputPassword();
        long money = inputMoney();
        long resultBalance = checkingAccountService.withdraw(WithdrawDTO.of(accountId, password, money));
        printSuccess(resultBalance);
    }

    private void transfer() {
        System.out.println("이체 서비스입니다.");
        long accountId = inputAccountId();
        long password = inputPassword();
        long money = inputMoney();
        long sendAccountId = inputSendAccountId();
        long resultBalance = checkingAccountService.transfer(TransferDTO.of(accountId, password, money, sendAccountId));
        printSuccess(resultBalance);
    }

    private void getBalance() {
        System.out.println("계좌 잔고 조회 서비스입니다.");
        long accountId = inputAccountId();
        long password = inputPassword();
        long resultBalance = checkingAccountService.getBalance(AccountSecurityDTO.of(accountId, password));
        printSuccess(resultBalance);
    }

    private void deleteAccount() {
        System.out.println("계좌 해지 서비스입니다.");
        long accountId = inputAccountId();
        long password = inputPassword();
        checkingAccountService.deleteAccount(AccountSecurityDTO.of(accountId, password));
        printSuccess();
    }

    private void getSavingBalance() {
        System.out.println("계좌 잔고 조회 서비스입니다.");
        long accountId = inputAccountId();
        long password = inputPassword();
        long resultBalance = savingsAccountService.getBalance(AccountSecurityDTO.of(accountId, password));
        printSuccess(resultBalance);
    }

    private int inputBankNum() {
        System.out.println("회원가입 할 은행을 선택해주세요.\n1. 솝트 뱅크 2. 가든 뱅크");
        return sc.nextInt();
    }

    private long inputCustomerId() {
        System.out.print("고객 번호를 입력하세요: ");
        return sc.nextLong();
    }

    private int inputAccountType() {
        System.out.println("계좌 유형을 선택하세요.\n1. Checking Account 2. Savings Account");
        return sc.nextInt();
    }

    private long inputAccountId() {
        System.out.print("계좌 번호를 입력하세요: ");
        return sc.nextLong();
    }

    private long inputPassword() {
        System.out.print("비밀 번호를 입력하세요: ");
        return sc.nextLong();
    }

    private long inputMoney() {
        System.out.print("금액을 입력하세요: ");
        return sc.nextLong();
    }

    private long inputSendAccountId() {
        System.out.print("이체할 계좌 번호를 입력하세요: ");
        return sc.nextLong();
    }

    private void printSuccess() {
        System.out.println("해당 서비스가 성공적으로 처리되었습니다.");
    }

    private void printSuccess(long resultBalance) {
        System.out.println("해당 서비스가 성공적으로 처리되었습니다.");
        System.out.println("잔여 금액: " + resultBalance);
    }

    private void printCustomer(Customer customer) {
        System.out.println("가입된 고객 정보: " + customer.getId() + ": " + customer.getPerson().getLastName() + customer.getPerson().getFirstName());
        System.out.println(customer.getPerson().getGender() + customer.getPerson().getPhoneNumber() + customer.getPerson().getBirth());
    }

    private void printAccount(Account account) {
        if (account.getAccountType() == AccountType.CHECKING) {
            System.out.println("계좌 유형: 입출금 통장");
        }
        else {
            System.out.println("계좌 유형: 적금 통장");
            System.out.println("이자율" + account.getRate());
        }
        System.out.println("계좌 번호" + account.getAccountId() + "\n잔여 금액" + account.getBalance());

    }

    private Bank choiceBank(int bankNum) {
        return switch (bankNum) {
            case 1 -> Bank.SOPT;
            case 2 -> Bank.GARDEN;
            default -> throw new CustomException(ErrorMessage.INVALID_INPUT_NUM);
        };
    }
}
