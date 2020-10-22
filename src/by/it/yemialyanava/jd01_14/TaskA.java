package by.it.yemialyanava.jd01_14;
/*В классе TaskA нужно выполнить следующие шаги:
         Записать в двоичный файл dataTaskA.bin 20 случайных чисел типа Integer.
         Файл должен быть в том же каталоге, что и исходный код для класса
        TaskA.java.
         Затем нужно прочитать записанный файл в коллекцию ArrayList.
         Вывести в консоль прочитанные числа через пробел
         Вывести с новой строки их среднее арифметическое avg=20.123.
         Продублировать вывод в консоль в файл resultTaskA.txt*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaskA {
    private static final String FILE_DATA = "dataTaskA.bin";
    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";
    private static final String RESULT_TASK_A = "resultTaskA.txt";

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
        String fileName = getPath(TaskA.class) + FILE_DATA;
        writeRandomInt(fileName);
        List<Integer> list = new ArrayList<>();
        readInt(fileName, list);
        printToConsole(list);
        String fileNameTxt = getPath(TaskA.class) + RESULT_TASK_A;
        printToFile(list, fileNameTxt);
    }

    private static void printToFile(List<Integer> list, String fileNameTxt) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(fileNameTxt);
            double sum2 = 0;
            for (Integer integer:list) {
                printWriter.print(integer + " ");
                sum2 += integer;
            }
            printWriter.println("\navg=" + sum2 / list.size());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(printWriter)){
                printWriter.close();
            }
        }
    }

    private static void printToConsole(List<Integer> list) {
        double sum = 0;
        for (Integer integer: list) {
            System.out.print(integer + " ");
            sum += integer;
        }
        System.out.println("\navg=" + sum/list.size());
    }

    private static void readInt(String fileName, List<Integer> list) {
        try (
                DataInputStream dataInputStream = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(fileName)
                        )
                )
        ) {
            while (dataInputStream.available()>0){
                list.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeRandomInt(String fileName) {
        try(
                DataOutputStream dataOutputStream = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(fileName)
                        )
                )
        ) {
            for (int i = 0; i < 20; i++) {
                int n = +12345/2 + (int) (Math.random() * 12345);
                dataOutputStream.writeInt(n);
            }
            dataOutputStream.writeInt(90 + (89<<8) + (88<<16) + 87 * 256 * 256 * 256);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
