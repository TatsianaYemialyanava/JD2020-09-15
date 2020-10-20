package by.it.frolova.jd01_14;

/*В файле с текстом TaskB.txt нужно подсчитать общее количество знаков
препинания и слов
 Вывести результат на консоль в виде одной строки:
words=123, punctuation marks=15
 Продублировать вывод в консоль в файл resultTaskB.txt*/

import java.io.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static final String USER_DIR = "user.dir";
    public static final String SRC = "src";
    public static final String TEXT_TXT = "text.txt";
    public static final String RESULT_TASK_B_TXT = "resultTaskB.txt";

    public static void main(String[] args) {
        Class<TaskB> bClass = TaskB.class;
        String fileName = getPath(bClass) + TEXT_TXT;
        String fileNameTxt = getPath(bClass) + RESULT_TASK_B_TXT;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int countWords = 0;
            int countMarks = 0;
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("\\.{3}", ".");
                Pattern pattWord = Pattern.compile("[а-яёА-ЯЁ]+");
                Matcher matchWord = pattWord.matcher(line);
                while (matchWord.find()) {
                    countWords++;
                }
                Pattern pattMark = Pattern.compile("[-.,;:!?]");
                Matcher matchMark = pattMark.matcher(line);
                while (matchMark.find()) {
                    countMarks++;
                }
            }
            System.out.printf("words=%d, punctuation marks=%d", countWords, countMarks);
            printToFile(fileNameTxt, countWords, countMarks);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printToFile(String fileNameTxt, int countWords, int countMarks) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileNameTxt);
            writer.printf("words=%d, punctuation marks=%d", countWords, countMarks);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (Objects.nonNull(writer)) {
                writer.close();
            }
        }
    }

    private static String getPath(Class<TaskB> bClass) {
        String packageName = bClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC + File.separator + packageName;
    }
}
