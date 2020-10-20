package by.it.frolova.jd01_15;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/*Создайте матрицу 6 строк на 4 столбца из целых случайных чисел от -15 до 15 включительно.
 Выведите матрицу в текстовый файл matrix.txt, расположенный в папке задания jd01_15. При выводе для
каждого числа нужно предусмотреть для него три знакоместа, после чисел – один пробел.
 Прочитайте файл и покажите его в консоли. Класс Scanner использовать нельзя.*/
public class TaskA {
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    public static final String MATRIX_TXT = "matrix.txt";

    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = -15 + (int) (Math.random() * 15);
            }
        }
        String filename = getPath(TaskA.class) + MATRIX_TXT;
        writeFile(matrix, filename);
        printFile(filename);
    }

    private static void printFile(String filename) {
        try {
            Files.lines(Paths.get(filename)).
                    forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeFile(int[][] matrix, String filename) {
        try(PrintWriter printWriter = new PrintWriter(filename)) {
            for (int[] row : matrix) {
                for (int element : row) {
                    printWriter.printf("%3s ",element);
                }
                printWriter.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getPath(Class<TaskA> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC + File.separator + packageName;
    }
}
