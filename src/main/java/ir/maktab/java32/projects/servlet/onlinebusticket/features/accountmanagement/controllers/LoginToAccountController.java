package ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.controllers;

import ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.models.User;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.services.impl.LoginToAccountByUserUseCaseImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginToAccountController extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        User user = new User();

        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        if (new LoginToAccountByUserUseCaseImpl().login(user) != null) {

        } else {
            out.print("Sorry username or password error");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
            requestDispatcher.include(request, response);
        }

        out.close();
    }
}
