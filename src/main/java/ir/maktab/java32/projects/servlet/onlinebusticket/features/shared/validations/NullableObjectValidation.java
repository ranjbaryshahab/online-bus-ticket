package ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.validations;


import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.exceptions.NullableObjectException;

public class NullableObjectValidation {
    public void validate(Object object, String exceptionMsg) throws NullableObjectException {
        if (object == null)
            throw new NullableObjectException(exceptionMsg);
        if (object instanceof String)
            if (object.toString().isEmpty())
                throw new NullableObjectException(exceptionMsg);
    }
}
