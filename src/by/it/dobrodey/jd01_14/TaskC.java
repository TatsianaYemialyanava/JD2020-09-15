package by.it.dobrodey.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;

/*
В классе TaskC нужно выполнить следующие шаги:
 Вывести список всех файлов и каталогов вашего пакета by.it.фамилия в
формате file:имя_файла или dir:имя_каталога.
 Продублировать вывод в консоль в файл resultTaskC.txt
 */
public class TaskC {

    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    public static final String FILE_DATA = "dataTaskA.bin";
    private static final String RESULT_TASK_C = "resultTaskC.txt";
    private static String filenameTxt;
    private static PrintWriter printWriter;

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

        String wayFile = getPath(TaskA.class);
        File userNameFile = new File(wayFile).getParentFile();
        File[] list = userNameFile.listFiles();
        System.out.println("Путь: " + userNameFile.getPath());
        System.out.println("Имя файла: " + userNameFile.getName());
        searchTypeFile(userNameFile);
        filenameTxt = getPath(TaskA.class) + RESULT_TASK_C;
        try {
            printWriter = new PrintWriter(filenameTxt);
            printToFile(userNameFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
        if (Objects.nonNull(printWriter)) {
            printWriter.close();
        }
    }

    }


    private static void searchTypeFile(File userNameFile) {
        if (userNameFile.isFile()) {
            System.out.printf("file:%s\n", userNameFile);
        }
        if (userNameFile.isDirectory()) {
            File[] list = userNameFile.listFiles();
            for (File file : list) {
                if (file.isFile()) {
                    System.out.printf("file:%s\n", file.getName());
                }
                if (file.isDirectory()) {
                    System.out.printf("dir:%s\n", file.getName());
                    searchTypeFile(file);
                }
            }
        }
    }

    private static void printToFile(File userNameFile) {

        if (userNameFile.isFile()) {
            printWriter.printf("file:%s\n", userNameFile);
        }
        if (userNameFile.isDirectory()) {
            File[] list = userNameFile.listFiles();
            for (File file : list) {
                if (file.isFile()) {
                    printWriter.printf("file:%s\n", file.getName());
                }
                if (file.isDirectory()) {
                    printWriter.printf("dir:%s\n", file.getName());
                    printToFile(file);
                }
            }
        }
    }
}

