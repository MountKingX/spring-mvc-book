package com.book.mvc.domain.repository;

import com.book.mvc.domain.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> getAllCustomers();
}
