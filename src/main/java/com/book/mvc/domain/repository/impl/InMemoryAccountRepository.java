package com.book.mvc.domain.repository.impl;

import com.book.mvc.domain.Account;
import com.book.mvc.domain.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryAccountRepository implements AccountRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Account getAccount(final String username) {
        final String sql = "SELECT * FROM accounts WHERE username = :username";
        final Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", username);
        try {
            return jdbcTemplate.queryForObject(sql, params, new InMemoryAccountRepository.AccountMapper());
        } catch (final DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Account> getAllAccounts() {
        final Map<String, Object> params = new HashMap<>();
        final List<Account> result
                = jdbcTemplate.query(
                "SELECT * FROM accounts",
                params,
                new InMemoryAccountRepository.AccountMapper()
        );
        return result;
    }

    @Override
    public void createAccount(final Account account) {
        final String sql = "INSERT INTO ACCOUNTS ("
                + "USERNAME,"
                + "NAME,"
                + "PASSWORD,"
                + "ROLE) "
                + "VALUES (:username, :name, :password, :role)";
        final Map<String, Object> params = new HashMap<>();
        params.put("username", account.getUsername());
        params.put("name", account.getName());
        params.put("password", account.getPassword());
        params.put("role", account.getRole());
        jdbcTemplate.update(sql, params);
    }

    private static final class AccountMapper implements RowMapper<Account> {
        public Account mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final Account account = new Account();
            account.setUsername(rs.getString("USERNAME"));
            account.setName(rs.getString("NAME"));
            account.setPassword(rs.getString("PASSWORD"));
            account.setRole(rs.getString("ROLE"));
            return account;
        }
    }
}
