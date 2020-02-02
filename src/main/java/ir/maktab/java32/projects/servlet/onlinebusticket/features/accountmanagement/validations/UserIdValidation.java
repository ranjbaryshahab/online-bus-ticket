package ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.validations;


import ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.repositories.UserRepository;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.enumeration.ExceptionMessage;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.exceptions.NullableObjectException;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.validations.NullableObjectValidation;

public class UserIdValidation {
    public void validate(Long id) throws NullableObjectException {
        new NullableObjectValidation().validate(UserRepository.getInstance().findById(id), ExceptionMessage.ID_NOT_EXIST.getMessage());
    }
}
