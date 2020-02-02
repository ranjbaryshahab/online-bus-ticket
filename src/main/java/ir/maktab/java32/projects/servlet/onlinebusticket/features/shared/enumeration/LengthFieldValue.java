package ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.enumeration;

public enum LengthFieldValue {
    FIRST_NAME(25),
    LAST_NAME(25),
    USERNAME(25),
    EMAIL(40),
    CAPTION(30),
    ;

    private final Integer length;

    LengthFieldValue(Integer length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

}
