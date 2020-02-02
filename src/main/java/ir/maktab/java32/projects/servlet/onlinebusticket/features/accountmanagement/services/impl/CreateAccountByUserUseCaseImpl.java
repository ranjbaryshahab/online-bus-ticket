package ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.services.impl;


import ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.models.User;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.repositories.UserRepository;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.services.CreateAccountByUserUseCase;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.validations.LengthUserFieldsValidation;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.validations.NullableUserFieldsValidation;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.validations.UniqueUsernameFieldValidation;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.exceptions.LengthFieldException;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.exceptions.NullableObjectException;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.exceptions.UniqueFieldException;

public class CreateAccountByUserUseCaseImpl implements CreateAccountByUserUseCase {

    @Override
    public User create(User user) {
        try {
            new NullableUserFieldsValidation().validate(user);
            new UniqueUsernameFieldValidation().validate(user);
            new LengthUserFieldsValidation().validate(user);
            return UserRepository.getInstance().save(user);
        } catch (LengthFieldException | UniqueFieldException | NullableObjectException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
