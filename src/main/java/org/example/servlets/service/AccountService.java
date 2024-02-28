package org.example.servlets.service;

import org.example.servlets.EmptyFieldException;
import org.example.servlets.exception.UserIsAlreadyExistsException;
import org.example.servlets.model.Account;

import java.util.Map;

public interface AccountService {
    Map<String, Account> allAccounts();
    void saveAccount(String name, String password, Double balance) throws UserIsAlreadyExistsException, EmptyFieldException;
}
