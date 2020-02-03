package ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.controllers;

import ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.models.User;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.services.impl.LoginToAccountByUserUseCaseImpl;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.service.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "checkLogin", urlPatterns = {"/view/login/checkLogin"})
public class LoginToAccountByUserController extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User loginUser = null;

        if (username != null && !username.equals("")) {
            if (password != null && !password.equals("")) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginUser = new LoginToAccountByUserUseCaseImpl().login(user);
            }
        }

        if (loginUser != null) {
            AuthenticationService.getInstance().setLoginUser(loginUser);
            HttpSession session = request.getSession(true);
            session.setAttribute("user_data", loginUser);
            response.sendRedirect("../buy-tickets/index.html");
        }

    }
}
