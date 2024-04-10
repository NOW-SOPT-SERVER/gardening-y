package org.example.dto;

import org.example.domain.Bank;
import org.example.domain.Person;

public record CreateCustomerDTO(
        Person person,
        Bank bank
) {
    public static CreateCustomerDTO of(Person person, Bank bank) {
        return new CreateCustomerDTO(person, bank);
    }
}
