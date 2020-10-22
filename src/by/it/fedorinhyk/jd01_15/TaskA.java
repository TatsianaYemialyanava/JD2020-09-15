package by.it.fedorinhyk.jd01_15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";
    private static final String MATRIX_TXT = "matrix.txt";

    @SuppressWarnings("SameParameterValue")
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
        int[][] matrix = new int[6][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (-15 + Math.random() * 31);
            }
        }

        String filename = getPath(TaskA.class) + MATRIX_TXT;
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (int[] row : matrix) {
                for (int element : row) {
                    writer.printf("%3d ", element);
                }
                writer.println();
            }
            Files.lines(Paths.get(filename)).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%3d ", element);
            }
            System.out.println();
            List<Integer> list = new ArrayList<>();
            reader(filename, list);
        }


    }

    private static void reader(String filename, List<Integer> matrix) {
        try (DataInputStream dataInputStream = new DataInputStream
                (new BufferedInputStream
                        (new FileInputStream(filename)))) {
            while (dataInputStream.available() > 0) {
                matrix.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
