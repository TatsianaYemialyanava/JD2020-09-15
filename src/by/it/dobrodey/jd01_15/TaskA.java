package by.it.dobrodey.jd01_15;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.lang.System.out;


public class TaskA {
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    private static final String MATRIX_TXT = "matrix.txt";

    @SuppressWarnings("SameParameterValue")
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

    public static void main(String[] args) {
        int[][] array = new int[6][4];
        for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = -15 + (int) (Math.random() * 31);
            }
        }

        String filename = getPath(TaskA.class) + MATRIX_TXT;
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (int[] row : array) {
                for (int value : row) {
                    writer.printf("%3d ", value);
                }
                writer.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Path path = Paths.get(filename);
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(out::println);
        } catch (IOException ignored) {
        }
    }
}
