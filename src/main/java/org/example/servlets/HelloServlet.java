package org.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servlets.model.Account;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    private Map<String, Account> repository;

    @Override
    public void init() throws ServletException {
        repository = new ConcurrentHashMap<>();

        Account user1 = new Account("Коля", "password1", 12000.0);
        Account user2 = new Account("Вася", "password2", 1305.0);
        Account user3 = new Account("Петя", "password3", 10.0);

        repository.put(user1.getName(), user1);
        repository.put(user2.getName(), user2);
        repository.put(user3.getName(), user3);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("accounts", repository.values());
        req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (repository.containsKey(name)) doGet(req, resp);
        String password = req.getParameter("password");
        Double balance = Double.valueOf(req.getParameter("balance"));
        Account account = new Account(name, password, balance);

        repository.put(name, account);

        doGet(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
