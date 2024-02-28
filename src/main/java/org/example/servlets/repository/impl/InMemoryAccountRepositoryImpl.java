package org.example.servlets.repository.impl;

import org.example.servlets.model.Account;
import org.example.servlets.repository.AccountRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryAccountRepositoryImpl implements AccountRepository {
    private Map<String, Account> accountRepo;

    public InMemoryAccountRepositoryImpl() {
        this.accountRepo = new ConcurrentHashMap<>();
        loadAccInDB();
    }

    private void loadAccInDB () {
        Account user1 = new Account("Коля", "password1", 12000.0);
        Account user2 = new Account("Вася", "password2", 1305.0);
        Account user3 = new Account("Петя", "password3", 10.0);

        accountRepo.put(user1.getName(), user1);
        accountRepo.put(user2.getName(), user2);
        accountRepo.put(user3.getName(), user3);
    };

    @Override
    public void saveAccount(Account account) {
        accountRepo.put(account.getName(), account);
        return;
    }

    @Override
    public Map<String, Account> allAccounts() {
        return accountRepo;
    }
}
