package by.it.arhipova.calculator;

public class CalcExeption extends Exception {
    public CalcExeption() {
        super();
    }

    public CalcExeption(String message) {
        super("ERROR: " + message);
    }

    public CalcExeption(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    public CalcExeption(Throwable cause) {
        super(cause);
    }

    protected CalcExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
