package org.example.service;

import org.example.common.CustomException;
import org.example.common.ErrorMessage;
import org.example.domain.Customer;
import org.example.dto.CreateCustomerDTO;
import org.example.dto.CustomerInfoDTO;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private static List<Customer> customers = new ArrayList<>();

    public Customer createCustomer(CreateCustomerDTO createCustomerDTO) {
        Customer customer = Customer.createCustomer(createCustomerDTO.person(), createCustomerDTO.bank());
        customers.add(customer);
        return customer;
    }

    public Customer getCustomer(CustomerInfoDTO customerInfoDTO) {
        return findCustomer(customerInfoDTO.customerId());
    }

    private Customer findCustomer(long customerId) {
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        throw new CustomException(ErrorMessage.NOT_FOUND_CUSTOMER);
    }

}
