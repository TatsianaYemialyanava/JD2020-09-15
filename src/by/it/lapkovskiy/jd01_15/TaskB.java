package by.it.lapkovskiy.jd01_15;

import java.io.*;

public class TaskB {
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    private static final String Task = "TaskB.java";
    private static final String RESULT_TASK_B = "TaskB.txt";

    public static void main(String[] args) {
        /*
        sss
         */
        /*
        sss
         */
        //www
        //www
        StringBuilder stringBuilder = new StringBuilder();
        deleteComm(stringBuilder);
        String s = stringBuilder.toString();
        setFileData(s);
        // System.out.println(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        check(stringBuilder);
        System.out.println(stringBuilder.toString());

    }

    public static void check(StringBuilder stringBuilder) {
        try {
            FileInputStream fileInputStream =
                    new FileInputStream(getPath(TaskB.class) + Task);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(fileInputStream, "UTF8"));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str + " ");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * @param stringBuilder
     */
    public static void deleteComm(StringBuilder stringBuilder) {
        try {
            boolean comm = false;//lololol
            FileInputStream fileInputStream =
                    new FileInputStream(getPath(TaskB.class) + Task);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(fileInputStream, "UTF8"));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                if (findComm(str) == -1 && findBlockComm(str) == 0 && !comm) {
                    stringBuilder.append(str + "\n");
                } else {
                    if (findComm(str) > 0 && !comm) {
                        stringBuilder.append(
                                String.copyValueOf(
                                        str.toCharArray(), 0, findComm(str) - 1)+"\n");
                    } else {
                        if (findBlockComm(str) > 0 && !comm) {
                            stringBuilder.append(
                                    String.copyValueOf(
                                            str.toCharArray(), 0, str.length()-1 - findBlockComm(str) - 1)+"\n");

                            comm = true;
                        } else if (findBlockComm(str) < 0) {
                            stringBuilder.append(
                                    String.copyValueOf(
                                            str.toCharArray(), (findBlockComm(str) - 1) * -1, str.length() - (findBlockComm(str) - 1) * -1)+"\n");
                            comm = false;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static int findComm(String line) {
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '/') {
                if (chars[i + 1] == '/') return i;
            }
        }
        return -1;
    }

    public static int findBlockComm(String line) {
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '/' || chars[i] == '*') {
                if (chars[i + 1] == '*') return (i + 1);
                if (chars[i + 1] == '/') return -(i + 1);
            }
        }
        return 0;
    }

    private static void setFileData(String line) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(getPath(TaskB.class) + RESULT_TASK_B);
            fileOutputStream.write(line.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {

        }
    }

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
}
