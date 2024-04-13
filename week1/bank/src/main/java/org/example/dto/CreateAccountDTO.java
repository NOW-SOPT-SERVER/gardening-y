package org.example.dto;

import org.example.domain.Bank;
import org.example.domain.Person;

public record CreateAccountDTO(
        Person person,
        Bank bank,
        long password
) {
    public static CreateAccountDTO of(Person person, Bank bank, long password) {
        return new CreateAccountDTO(person, bank, password);
    }
}
