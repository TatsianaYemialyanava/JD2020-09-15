package by.it.yemialyanava.home;
/*Создать объект Person с полями name, surname, age. Сгенерировать 10 объектов класса Person со случайными полями
 соответструющего типа. С помощью Java создать файл, в который запишется информация о этих людях*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.UUID;

public class Person {

    private static String name;
    private static String surname;
    private static int age;
    private static final String TEXT_DATA = "text.txt";
    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";
    private static final String RESULT_PERSON = "resultPerson.txt";

    private static String getPath(Class<?> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC + File.separator + packageName;
    }

    public static void main(String[] args) {
        StringBuilder outputnames = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            Person man = new Person();
            name = UUID.randomUUID().toString();
            surname = UUID.randomUUID().toString();
            age = (int) (Math.random() * 90);
            outputnames.append(name).append(" ").append(surname).append(" ").append(age).append("\n");
            System.out.println(name + "   " + surname + "   " + age);
        }
            String fileNameTxt = getPath(Person.class) + RESULT_PERSON;
            printToFile(outputnames.toString(),fileNameTxt);
    }

    private static void printToFile(String strToFile, String fileNameTxt) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(fileNameTxt);
            printWriter.println(strToFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(printWriter)) {
                printWriter.close();
            }
        }
    }
}
