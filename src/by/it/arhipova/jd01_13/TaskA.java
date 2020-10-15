package by.it.arhipova.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        }catch (NumberFormatException | NullPointerException e){
            Class<? extends RuntimeException> aClass = e.getClass();
            String exeptionName = aClass.getName();
            StackTraceElement[] stackTrace = e.getStackTrace();
            printInfoAboutExeption(exeptionName, stackTrace);
        }
    }

    private static void printInfoAboutExeption(Object exeptionName, StackTraceElement[] stackTrace) {
        for (StackTraceElement traceElement : stackTrace){
            String methodName = traceElement.getMethodName();
            if (methodName.equals("main")){
                String className = traceElement.getClassName();
                int lineNumber = traceElement.getLineNumber();
                System.out.printf(" name: %s\n class: %s\n line:%d\n", exeptionName, className, lineNumber);
                break;
            }
        }
    }
}
