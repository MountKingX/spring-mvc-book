package com.book.mvc.domain.repository.impl;

import com.book.mvc.domain.Customer;
import com.book.mvc.domain.repository.CustomerRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> getAllCustomers() {
        final Map<String, Object> params = new HashMap<>();
        final List<Customer> result
                = jdbcTemplate.query(
                        "SELECT * FROM customers",
                        params,
                        new InMemoryCustomerRepository.CustomerMapper()
        );
        return result;
    }

    private static final class CustomerMapper implements RowMapper<Customer> {
        public Customer mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final Customer customer = new Customer();
            customer.setCustomerId(rs.getString("ID"));
            customer.setName(rs.getString("NAME"));
            customer.setAddress(rs.getString("ADDRESS"));
            customer.setNoOfOrdersMade(rs.getLong("NO_of_ORDERS_MADE"));
            return customer;
        }
    }
}
