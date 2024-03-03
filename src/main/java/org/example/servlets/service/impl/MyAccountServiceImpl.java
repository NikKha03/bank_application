package org.example.servlets.service.impl;

import org.example.servlets.EmptyFieldException;
import org.example.servlets.exception.UserIsAlreadyExistsException;
import org.example.servlets.model.Account;
import org.example.servlets.repository.AccountRepository;
import org.example.servlets.repository.impl.InMemoryAccountRepositoryImpl;
import org.example.servlets.service.AccountService;
import org.example.servlets.util.ObjectFactory;

import java.util.Map;

public class MyAccountServiceImpl implements AccountService {
    private AccountRepository repository;

    public MyAccountServiceImpl() {
        try {
            this.repository = ObjectFactory.getInstance().createObject(AccountRepository.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<String, Account> allAccounts() {
        return repository.allAccounts();
    }

    @Override
    public void saveAccount(String name, String password, Double balance) throws UserIsAlreadyExistsException, EmptyFieldException {
        if (repository.allAccounts().containsKey(name)) throw new UserIsAlreadyExistsException(name + " is already exists");
        if (name.isEmpty() || password.isEmpty()) throw new EmptyFieldException("name and password cannot be empty");
        Account account = new Account(name, password, balance);
        repository.saveAccount(account);

    }
}
