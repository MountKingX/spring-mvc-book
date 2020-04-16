package com.book.mvc.service.impl;

import com.book.mvc.domain.Account;
import com.book.mvc.domain.repository.AccountRepository;
import com.book.mvc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account getAccount(final String username) {
        return accountRepository.getAccount(username);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }

    @Override
    public void createAccount(final Account account) {
        accountRepository.createAccount(account);
    }
}
