package ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.services.impl;


import ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.repositories.UserRepository;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.services.DeleteAccountByUserUseCase;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.validations.UserIdValidation;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.exceptions.NullableObjectException;

public class DeleteAccountByUserUseCaseImpl implements DeleteAccountByUserUseCase {

    @Override
    public int delete(Long id) {
        try {
            new UserIdValidation().validate(id);
            UserRepository.getInstance().removeById(id);
            return 1;
        } catch (NullableObjectException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
