package com.book.mvc.domain.repository;

import com.book.mvc.domain.Account;

import java.util.List;

public interface AccountRepository {

    Account getAccount(final String username);

    List<Account> getAllAccounts();

    void createAccount(final Account account);
}
