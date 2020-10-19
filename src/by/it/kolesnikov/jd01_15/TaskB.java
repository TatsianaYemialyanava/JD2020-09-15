package by.it.kolesnikov.jd01_15;

// однострочный 1
// однострочный 2
/*
многострочный 1
*/
/*
многострочный 2
*/
/**
 * javadoc
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";
    private static final String TASK_B = "TaskB.java";

    public static void main(String[] args) {
        String filename = getPath(TaskB.class)+ TASK_B;
        StringBuilder text = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            while (bufferedReader.ready()) {
                String s = bufferedReader.readLine();
          if (s.startsWith("/"))
                text.append(s+"\n");
            }
            System.out.println(text);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static String getPath(Class<TaskB> bClass) {
        String packageName = bClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        //получаем корень проекта Root
        String property = System.getProperty(USER_DIR);
        return property + File.separator + SRC + File.separator + packageName;
    }
}
