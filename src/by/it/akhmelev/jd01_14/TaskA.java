package by.it.akhmelev.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class TaskA {

    private static final String FILE_DATA = "dataTaskA.bin";
    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";
    private static final String RESULT_TASK_A = "resultTaskA.txt";

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
        String filename = getPath(TaskA.class) + FILE_DATA;
        writeRandomInt(filename);
        List<Integer> list = new ArrayList<>();
        readInt(filename, list);
        printToConsole(list);
        String filenameTxt = getPath(TaskA.class) + RESULT_TASK_A;
        printToFile(list, filenameTxt);
    }

    private static void writeRandomInt(String filename) {
        try (
                DataOutputStream dataOutputStream = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(filename)
                        )
                )
        ) {
            for (int i = 0; i < 20; i++) {
                int n = -12345 / 2 + (int) (Math.random() * 12345);
                dataOutputStream.writeInt(n);
            }
            dataOutputStream.writeInt(90 + (89 << 8) + (88 << 16) + 87 * 256 * 256 * 256);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readInt(String filename, List<Integer> list) {
        try (
                DataInputStream dataInputStream = new DataInputStream(
                        new BufferedInputStream(new FileInputStream(filename)
                        )
                )
        ) {
            while (dataInputStream.available() > 0) {
                list.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printToConsole(List<Integer> list) {
        double sum = 0;
        for (Integer integer : list) {
            System.out.print(integer + " ");
            sum += integer;
        }
        System.out.println("\navg=" + sum / list.size());
    }

    private static void printToFile(List<Integer> list, String filenameTxt) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(filenameTxt);
            double sum2 = 0;
            for (Integer integer : list) {
                printWriter.print(integer + " ");
                sum2 += integer;
            }
            printWriter.println("\navg=" + sum2 / list.size());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(printWriter)) {
                printWriter.close();
            }
        }
    }
}
