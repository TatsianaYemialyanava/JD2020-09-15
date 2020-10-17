package by.it.frolova.jd01_14;

/*В классе TaskC нужно выполнить следующие шаги:
 Вывести список всех файлов и каталогов вашего пакета by.it.фамилия в
формате file:имя_файла или dir:имя_каталога.
 Продублировать вывод в консоль в файл resultTaskC.txt*/

import java.io.*;

public class TaskC {

    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    public static final String RESULT_TASK_C_TXT = "resultTaskC.txt";

    public static void main(String[] args) {

        String root = getPath(TaskC.class);
        File path = new File(root).getParentFile();
        try (FileOutputStream fos = new FileOutputStream(getPath(TaskC.class) + RESULT_TASK_C_TXT)) {
            PrintStream printStream = new PrintStream(fos);
            printFileTree(path, printStream);
        } catch (IOException e) {
            throw new RuntimeException();
        }
        printFileTree(path, System.out);
    }

    private static void printFileTree(File path, PrintStream writer) {
        File[] files = path.listFiles();
        for (File element : files) {
            if (element.isFile()) {
                writer.printf("file:%s\n", element.getName());
            } else if (element.isDirectory()) {
                writer.printf("dir:%s\n", element.getName());
                printFileTree(element, writer);
            }
        }
    }

    private static String getPath(Class<TaskC> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC + File.separator + packageName;
    }
}
