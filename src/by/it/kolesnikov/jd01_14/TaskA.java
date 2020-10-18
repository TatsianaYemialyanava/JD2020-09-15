package by.it.kolesnikov.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class TaskA {
    //Объявляем контейнеры с константами (удобнее)
    static final String FILE_DATA = "dataTaskA.bin";
    static final String SRC = "src";
    static final String USER_DIR = "user.dir";
    public static final String RESULT_TASK_A = "resultTaskA.txt";

    static String getPath(Class<TaskA> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        //получаем корень проекта Root
        String property = System.getProperty(USER_DIR);
        return property + File.separator + SRC + File.separator + packageName;
    }

    public static void main(String[] args) {
        String filename = getPath(TaskA.class) + FILE_DATA;
        binaryOutput(filename);
        List<Integer> list = getIntegers(filename);
        printToConsole(list);
        String filenametxt = getPath(TaskA.class)+ RESULT_TASK_A;
        printToFile(list, filenametxt);
    }

    static void binaryOutput(String filename) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))) {
            for (int i = 0; i < 20; i++) {
                int n = -12345 / 2 + (int) (Math.random() * 12345);
                dataOutputStream.writeInt(n);
            }
            dataOutputStream.writeInt(90 + (89 << 8) + (88 << 16) + 87 * 256 * 256 * 256);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static List<Integer> getIntegers(String filename) {
        List<Integer> list = new ArrayList<>();
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)))) {
            while (dataInputStream.available() > 0) {
                list.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    static void printToConsole(List<Integer> list) {
        //print to console
        double sum = 0;
        for (Integer integer : list) {
            System.out.print(integer + " ");
            sum += integer;
        }
        System.out.println("\navg=" + sum / list.size());
    }

    static void printToFile(List<Integer> list, String filenametxt) {
        PrintWriter printWriter = null;
        try {
            printWriter=new PrintWriter(filenametxt);
            double sum2 = 0;
            for (Integer integer : list) {
                printWriter.print(integer+" ");
                sum2 += integer;
            }
            printWriter.println("\n"+sum2/ list.size());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            if (Objects.nonNull(printWriter)){
                printWriter.close();
            }
        }
    }
}