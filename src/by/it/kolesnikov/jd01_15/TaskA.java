package by.it.kolesnikov.jd01_15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

class TaskA {
    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";
    private static final String MATRIX_TXT = "matrix.txt";

    public static void main(String[] args) {
        int [][] arr = new int [6][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = -15 + (int) (Math.random() * 31);
            }
        }
        String filename = getPath(TaskA.class)+ MATRIX_TXT;
        try(PrintWriter printWriter = new PrintWriter(filename)) {
            for (int[] row : arr) {
                for (int value : row) {
                    printWriter.printf("%3d ", value);
                }
                printWriter.println();
            }
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());

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
        //получаем корень проекта Root
        String property = System.getProperty(USER_DIR);
        return property + File.separator + SRC + File.separator + packageName;
    }
}
