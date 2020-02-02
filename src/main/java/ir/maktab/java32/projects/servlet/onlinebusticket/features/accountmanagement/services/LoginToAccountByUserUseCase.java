package ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.services;


import ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.models.User;

public interface LoginToAccountByUserUseCase {
    User login(User user);
}
