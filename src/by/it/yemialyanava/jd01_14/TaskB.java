package by.it.yemialyanava.jd01_14;
         /*В классе TaskB нужно выполнить следующие шаги:
          В файле с текстом TaskB.txt нужно подсчитать общее количество знаков
         препинания и слов
          Вывести результат на консоль в виде одной строки:
         words=123, punctuation marks=15
          Продублировать вывод в консоль в файл resultTaskB.txt*/

import java.io.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static final String TEXT_DATA = "text.txt";
    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";
    private static final String RESULT_TASK_B = "resultTaskB.txt";

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
        String textName = getPath(TaskB.class) + TEXT_DATA;
        try (
                BufferedReader bufferedReader = new BufferedReader(
                        new FileReader(textName)
                )
        ) {
            int znaki = 0;
            int slova = 0;
            String line = bufferedReader.readLine();
            while (line != null) {
                Pattern patternSlova = Pattern.compile("[А-Яа-яЁё]+");
                Matcher matcherSlova = patternSlova.matcher(line);
                while (matcherSlova.find()) {
                    slova++;
                }
                line = line.replaceAll("(\\.{3})", ".");
                Pattern patternZnaki = Pattern.compile("[-\\?!,;:\\.]");
                Matcher matcherZnaki = patternZnaki.matcher(line);
                while (matcherZnaki.find()) {
                    znaki++;
                }
                line = bufferedReader.readLine();
            }
            String strToFile = "words=" + slova + " " + "punctuation marks=" + znaki;
            System.out.println(strToFile);

            String fileNameTxt = getPath(TaskB.class) + RESULT_TASK_B;
            printToFile(strToFile, fileNameTxt);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static void printToFile(String strToFile, String fileNameTxt) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(fileNameTxt);
            printWriter.println(strToFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(printWriter)) {
                printWriter.close();
            }
        }
    }

}
