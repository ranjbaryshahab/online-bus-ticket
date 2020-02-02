package ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.service;


import ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.models.User;

public final class AuthenticationService {

    private static AuthenticationService authenticationService;
    private User loginUser;

    public static synchronized AuthenticationService getInstance() {
        if (authenticationService == null)
            authenticationService = new AuthenticationService();
        return authenticationService;
    }

    private AuthenticationService() {
    }

    public void setLoginUser(User user) {
        this.loginUser = user;
    }

    public User getLoginUser() {
        return loginUser;
    }
}
