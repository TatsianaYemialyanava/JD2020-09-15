package by.it.yemialyanava.Calculator;

public class CalcException extends Exception  {
    public CalcException(){
        super();
    }

    public CalcException(String message){
        super("ERROR: " + message);
    }

    public CalcException(Throwable cause){
        super(cause);
    }

    public CalcException(String message, Throwable cause){
        super("ERROR: " + message, cause);
    }
}
