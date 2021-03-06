package com.book.mvc.service.impl;

import com.book.mvc.domain.Customer;
import com.book.mvc.domain.repository.CustomerRepository;
import com.book.mvc.service.CustomerService;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }
}
