package by.it.dobrodey.jd01_14;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
TaskB нужно выполнить следующие шаги:
 В файле с текстом TaskB.txt нужно подсчитать общее количество знаков
препинания и слов
 Вывести результат на консоль в виде одной строки:
words=123, punctuation marks=15
 Продублировать вывод в консоль в файл resultTaskB.txt
 */
public class TaskB {

    public static final String TEXT_TXT = "text.txt";
    public static final String RESULT_TASK_B_TXT = "resultTaskB.txt";

    private static String getPath(Class<?> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty("user.dir");
        return root + File.separator + "src" + File.separator + packageName;
    }

    public static void main(String[] args) {
        String filename = getPath(TaskB.class) + TEXT_TXT;
        String resultfilename = getPath(TaskB.class) + RESULT_TASK_B_TXT;
        try (
                BufferedReader reader = new BufferedReader(
                        new FileReader(filename)
                )
        ) {
            int sumMars = 0;
            int sumWord = 0;
            String line = reader.readLine();
            while (line != null) {
                line = line.replaceAll("(\\.{3})", ".");
                Pattern patternWord = Pattern.compile("[А-Яа-яЁё]+");
                Matcher matcherWord = patternWord.matcher(line);
                Pattern patternMark = Pattern.compile("[?!,;:.-]");
                Matcher matcherMark = patternMark.matcher(line);
                while (matcherWord.find()) {
                    sumWord++;
                }
                while (matcherMark.find()){
                sumMars++;
            }
            line = reader.readLine();}
            System.out.printf("words=%d, punctuation marks=%d", sumWord, sumMars);
            printToFile(resultfilename,sumWord,sumMars);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }
    private static void printToFile( String resultfilename,int sumWord,int sumMars) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(resultfilename);
            printWriter.printf("words=%d, punctuation marks=%d", sumWord, sumMars);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(printWriter)) {
                printWriter.close();
            }
        }
    }
}

