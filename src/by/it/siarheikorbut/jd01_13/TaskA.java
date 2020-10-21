package by.it.siarheikorbut.jd01_13;

import java.util.HashMap;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1Ryp9d5F9tODmNRVG6-eStmPl4TFplV3-/view?usp=sharing">Задание JD01_13 ( A1 )</a>
 */

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("Привет");
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (TaskA.class.getName().equals(element.getClassName())) {
                    System.out.println(element);
                    String name = e.getClass().getName();
                    String clName = element.getClassName();
                    int number = element.getLineNumber();
                    System.out.printf(
                            " name: %s\n" +
                                    "class: %s\n" +
                                    " line: %s\n",
                            name, clName, number);
                    break;
                }
            }
        }
    }
}