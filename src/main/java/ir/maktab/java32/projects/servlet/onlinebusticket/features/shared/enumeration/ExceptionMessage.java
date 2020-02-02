package ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.enumeration;

public enum ExceptionMessage {


    ID_NOT_EXIST(1, "This id not exist !!!"),

    FIRST_NAME_LARGER(2, "First name field input value larger than allowed !!!"),

    LAST_NAME_LARGER(3, "Last name field input value larger than allowed !!!"),

    EMAIL_LARGER(4, "Email field input value larger than allowed !!!"),

    USERNAME_LARGER(5, "Username field input value larger than allowed !!!"),

    UNIQUE_USERNAME(6, "This username is exist in the database !!!"),

    FIRST_NAME_REQUIRED(7, "First name is required ! Please input it !!!"),

    LAST_NAME_REQUIRED(8, "Last name is required ! Please input it !!!"),

    EMAIL_REQUIRED(9, "Email is required ! Please input it !!!"),

    USERNAME_REQUIRED(10, "Username is required ! Please input it !!!"),

    PASSWORD_REQUIRED(11, "Password is required ! Please input it !!!"),

    USERNAME_OR_PASSWORD_INCORRECT(12, "Username or password is incorrect !!!"),

    USERNAME_NOT_FOUND(13, "This username not found !!!"),

    CAPTION_REQUIRED(14, "Caption is required ! Please input it !!!"),

    CONTENT_REQUIRED(15, "Content is required ! Please input it !!!"),

    CAPTION_LARGER(16, "Email field input value larger than allowed !!!"),

    ACCOUNT_HAVE_NOT_ANY_POSTS(17, "This account have not any posts !!!");

    private final Integer code;
    private final String message;

    ExceptionMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + message;
    }
}
