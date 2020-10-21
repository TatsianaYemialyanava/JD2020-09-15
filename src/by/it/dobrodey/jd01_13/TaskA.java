package by.it.dobrodey.jd01_13;
/*
 программно обработайте исключения: определите и выведите в консоль
имя исключения, имя класса, номер строки класса TaskA в которой это исключение возникло.
 формат вывода
 name: java.lang.NullPointerException
class: by.it.вашпакет.jd01_13.TaskA
 line: 8
 никаких других данных выводиться не должно.
 */
import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try{
        if (Math.random()>0.5)
            new HashMap<String, String>(null);
        else
            Integer.parseInt("привет");
        } catch (NumberFormatException | NullPointerException e) {
            Class<? extends RuntimeException> aClass = e.getClass();
            String aClassName = aClass.getName();
            System.out.println("aClass="+aClassName);
            StackTraceElement[] stackTrace = e.getStackTrace();
            System.out.println("stackTrace= "+stackTrace.length);
            for (StackTraceElement stackTraceElement : stackTrace) {
                String methodName = stackTraceElement.getMethodName();
                if (methodName.equals("main")) {
                    String className = stackTraceElement.getClassName();
                    System.out.println("className"+className);
                    int lineNumber = stackTraceElement.getLineNumber();
                    System.out.printf("  name: %s\n class: %s\n  line:%d \n",
                            aClassName, className, lineNumber);
                    break;
                }
            }
        }
    }
}
