package by.it.kolesnikov.jd01_14;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    static final String SRC = "src";
    static final String USER_DIR = "user.dir";
    private static final String RESULT_TASK_B = "resultTaskB.txt";

    public static void main(String[] args) {
        String text = getPath(TaskB.class)+"text.txt";
        StringBuilder luk = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(text))){
            while (bufferedReader.ready()) {         // чтение одного байта.
               luk.append(bufferedReader.readLine()+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(luk);
        while (matcher.find()){
            String word = matcher.group();
            words.add(word);
        }
        int quantityWords =0;
        for (int i = 0; i < words.size(); i++) {
            quantityWords++;
        }

        List<String> marks = new ArrayList<>();
        Pattern pattern1 = Pattern.compile("\\s*[.,;:?!-]+");
        Matcher matcher1 = pattern1.matcher(luk);
        while (matcher1.find()){
            String mark = matcher1.group();
            marks.add(mark);
        }
        int quantityMarks =0;
        for (int i = 0; i < marks.size(); i++) {
            quantityMarks++;
        }
        String all = "words="+quantityWords+", "+"punctuation marks="+quantityMarks;
        System.out.println(all);
        String taskB = getPath(TaskB.class)+ RESULT_TASK_B;
        try(PrintWriter printWriter = new PrintWriter(taskB)) {
            printWriter.print(all);
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
    }

    static String getPath(Class<TaskB> bClass) {
        String packageName = bClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        //получаем корень проекта Root
        String property = System.getProperty(USER_DIR);
        return property + File.separator + SRC + File.separator + packageName;
    }
}
