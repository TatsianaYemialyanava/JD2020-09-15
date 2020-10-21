package by.it.yemialyanava.jd01_15;
/*Класс TaskC Нужно реализовать на java приложение - аналог командной строки Windows. Приложение должно
        использовать класс File и поддерживать две команды консоли:
         команду cd - смена каталога (посмотрите пример: Win+R → cmd → cd \ → dir ). В тестах проверяются всего
        две команды cd .. и cd имя_папки_в_текущем_каталоге
         команду dir - вывод каталога, формат вывода - аналогичный формату в Windows.
         команда end – завершение работы.
         Стартовым каталогом при запуске приложения должна быть папка by.it.ваша_фамилия.jd01_15.*/

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;
import java.util.Scanner;

public class TaskC {
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    //private static final String MATRIX_TXT = "matrix.txt";

    private static String getPath(Class<?> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC +
                File.separator + packageName;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String dirName = getPath(TaskC.class);
        File currentFile = new File(dirName);
        System.out.printf("Current dir: %s \n", currentFile.getAbsolutePath());
        boolean exit = false;

        while (scan.hasNext() && !exit) {
            String command = scan.nextLine();
            String commandName = null;
            if (command.indexOf(" ") > 0) {
                commandName = command.substring(0, command.indexOf(" "));
            } else {
                commandName = command.substring(0, command.length());
            }

            switch (commandName) {
                case "end":
                    exit = true;
                    break;
                case "dir":
                    printDir(currentFile, command);
                    break;
                case "cd":
                    currentFile = changeDir(currentFile, command);
                    break;
            }
        }
    }

    private static File changeDir(File currentFile, String command) {
        File result = null;
        String commandArg = command.substring(command.indexOf(" ") + 1, command.length());
        if (commandArg.equals("..")) {
            result = currentFile.getParentFile();
        } else {
            String childPath = currentFile.getAbsolutePath() + File.separator + commandArg;
            result = new File(childPath);
        }
        System.out.printf("Current dir: %s \n", result.getAbsolutePath());
        return result;
    }

    private static void printDir(File currentFile, String command) {
        File[] children = currentFile.listFiles();
        for (File child : children) {
            Date modificationDate = new Date(child.lastModified());
            String type = "";
            if (child.isDirectory()) {
                type = "DIR";
            }
            String modificationDateStr = String.format("%1$td.%1$tm.%1$ty", modificationDate);
            System.out.printf("%s <%s> %s\n", modificationDateStr, type, child.getName());
        }
    }
}
