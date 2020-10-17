package by.it.frolova.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class TaskA {

    private static final String USER_DIR = "user.dir";
    private static final String FILE_DATA = "dataTaskA.bin";
    private static final String SRC = "src";
    private static final String RESULT_TASK_A_TXT = "resultTaskA.txt";

    public static void main(String[] args) {
        Class<TaskA> aClass = TaskA.class;
        String fileName = getPath(aClass) + FILE_DATA;
        writeRandomInt(fileName);
        List<Integer> list = new ArrayList<>();
        readIntoArray(fileName, list);
        readToConsole(fileName, list);
        String filenameTxt = getPath(TaskA.class) + RESULT_TASK_A_TXT;
        printToFile(list, filenameTxt);
    }

    private static void printToFile(List<Integer> list, String filenameTxt) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(filenameTxt);
            double sum = 0;
            for (Integer element : list) {
                printWriter.print(element + " ");
                sum += element;
            }
            printWriter.print("\navg=" + (sum / list.size()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (Objects.nonNull(printWriter)) {
                printWriter.close();
            }
        }
    }

    private static void readToConsole(String fileName, List<Integer> list) {
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            double sum = 0;
            for (Integer element : list) {
                System.out.print(element + " ");
                sum += element;
            }
            System.out.print("\navg=" + (sum / list.size()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readIntoArray(String fileName, List<Integer> list) {
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            while (dataInputStream.available() > 0) {
                list.add(dataInputStream.readInt());
            }
            System.out.println(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeRandomInt(String fileName) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            for (int i = 0; i < 20; i++) {
                int n = -12345 / 2 + (int) (Math.random() * 12345);
                dataOutputStream.writeInt(n);
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
