package com.book.mvc.service;

import com.book.mvc.domain.Account;

import java.util.List;

public interface AccountService {

    Account getAccount(final String username);

    List<Account> getAllAccounts();

    void createAccount(final Account account);
}
