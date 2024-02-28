package org.example.servlets.repository;

import org.example.servlets.model.Account;

import java.util.Map;

public interface AccountRepository {
    Map<String, Account> allAccounts();
    void saveAccount(Account account);
}
