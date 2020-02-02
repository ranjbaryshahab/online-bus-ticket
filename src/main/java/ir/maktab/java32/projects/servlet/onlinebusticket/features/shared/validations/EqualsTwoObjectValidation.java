package ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.validations;


import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.exceptions.EqualsTwoObjectException;

public class EqualsTwoObjectValidation {
    public void validate(Object one, Object two, String exceptionMessage) throws EqualsTwoObjectException {
        if (!one.equals(two))
            throw new EqualsTwoObjectException(exceptionMessage);
    }
}
