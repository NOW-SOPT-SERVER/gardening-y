package org.example.common;

public enum ErrorMessage {
    NOT_FOUND_CUSTOMER("존재하지 않는 회원입니다."),
    NOT_FOUND_ACCOUNT("존재하지 않는 계좌번호입니다."),
    INVALID_ACCOUNT_PASSWORD("잘못된 비밀번호입니다."),
    INVALID_ACCOUNT_BALANCE("통장 잔액이 부족합니다."),
    INVALID_INPUT_NUM("메뉴를 잘못 입력했습니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
