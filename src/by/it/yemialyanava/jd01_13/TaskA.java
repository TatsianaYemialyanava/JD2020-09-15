package by.it.yemialyanava.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random()>0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch ( NumberFormatException |NullPointerException e){
            Class<? extends RuntimeException> aClass = e.getClass();
            String exceptionName = aClass.getName();
            StackTraceElement[] stackTrace = e.getStackTrace();
            printException(exceptionName, stackTrace);
        }
    }

    private static void printException(String exceptionName, StackTraceElement[] stackTrace) {
        for (StackTraceElement traceElement : stackTrace) {
            String methodname = traceElement.getMethodName();
            if (methodname.equals("main")){
                String className = traceElement.getClassName();
                int lineNumber = traceElement.getLineNumber();
                System.out.printf("  name: %s\n class: %s\n line: %s\n", exceptionName, className, lineNumber);
                break;
            }
        }
    }
}
