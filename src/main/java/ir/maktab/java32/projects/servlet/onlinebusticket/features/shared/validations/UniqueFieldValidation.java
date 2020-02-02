package ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.validations;


import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.exceptions.UniqueFieldException;

import java.util.List;

public class UniqueFieldValidation {
    public void validate(List<String> list, String string, String exceptionMsg) throws UniqueFieldException {
        boolean anyMatch = list.stream().anyMatch(s -> s.equals(string));

        if (anyMatch)
            throw new UniqueFieldException(exceptionMsg);
    }
}
