package by.it.yemialyanava.jd01_15;
/*Класс TaskA
         Создайте матрицу 6 строк на 4 столбца из целых случайных чисел от -15 до 15 включительно.
         Выведите матрицу в текстовый файл matrix.txt, расположенный в папке задания jd01_15. При выводе для
        каждого числа нужно предусмотреть для него три знакоместа, после чисел – один пробел.
         Прочитайте файл и покажите его в консоли. Класс Scanner использовать нельзя.*/

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.lang.System.*;

public class TaskA {
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    private static final String MATRIX_TXT = "matrix.txt";

    private static String getPath(Class<?> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = getProperty(USER_DIR);
        return root + File.separator + SRC +
                File.separator + packageName;
    }

    public static void main(String[] args) {
        int[][] array = new int[6][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = -15 + (int) (Math.random() * 31);
            }
        }

        String fileName = getPath(TaskA.class) + MATRIX_TXT;

        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (int[] row : array) {
                for (int value : row) {
                    writer.printf("%3d ", value);
                }
                writer.println();
            }
            writer.flush();
            Files.lines(Paths.get(fileName)).forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

