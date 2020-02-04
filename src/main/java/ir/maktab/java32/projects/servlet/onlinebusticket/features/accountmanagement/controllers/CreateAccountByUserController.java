package ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.controllers;


import ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.models.User;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.services.impl.CreateAccountByUserUseCaseImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "signUp", urlPatterns = {"/view/sign-up/signUp"})
public class CreateAccountByUserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first-name");
        String lastName = req.getParameter("last-name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username != null && !username.equals("")) {
            if (password != null && !password.equals("")) {
                User user = new User();
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setUsername(username);
                user.setPassword(password);
                new CreateAccountByUserUseCaseImpl().create(user);
                resp.sendRedirect("../login/login.jsp");
            }
        }
    }
}
