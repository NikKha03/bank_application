package org.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servlets.exception.UserIsAlreadyExistsException;
import org.example.servlets.service.AccountService;
import org.example.servlets.service.impl.MyAccountServiceImpl;

import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    private AccountService service;

    @Override
    public void init() throws ServletException {
        service = new MyAccountServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("accounts", service.allAccounts().values());
        req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            service.saveAccount(req.getParameter("name"),
                    req.getParameter("password"),
                    Double.parseDouble(req.getParameter("balance")));
        } catch (UserIsAlreadyExistsException e) {
            req.setAttribute("accountExistsError", true);
        } catch (EmptyFieldException e) {
            req.setAttribute("emptyFiled", true);
        } finally {
            doGet(req, resp);
        }
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
