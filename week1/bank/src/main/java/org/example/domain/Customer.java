package org.example.domain;

import org.example.domain.common.BaseTime;

import java.util.List;

public class Customer extends BaseTime {
    private  static long idCounter = 0L;

    private final long id;
    private final Person person;
    private final Bank bank;
    private List<Account> accounts;

    public Customer(Person person, Bank bank) {
        this.id = ++idCounter;
        this.person = person;
        this.bank = bank;
    }

    public static Customer createCustomer(Person person, Bank bank) {
        return new Customer(person, bank);
    }

    public long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }
}
