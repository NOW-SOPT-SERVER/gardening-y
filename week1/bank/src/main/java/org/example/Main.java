package org.example;


import org.example.domain.Gender;
import org.example.domain.Person;
import org.example.menu.Menu;
import org.example.service.CheckingAccountService;
import org.example.service.CustomerService;
import org.example.service.SavingsAccountService;

public class Main {
    private static final Person person1 = new Person("garden", "Yoon", "20000101", Gender.FEMALE, "112");

    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        CheckingAccountService checkingAccountService = new CheckingAccountService(customerService);
        SavingsAccountService savingsAccountService = new SavingsAccountService(customerService);

        Menu menu = new Menu(customerService, checkingAccountService, savingsAccountService);

        menu.startMenu(person1);
    }
}