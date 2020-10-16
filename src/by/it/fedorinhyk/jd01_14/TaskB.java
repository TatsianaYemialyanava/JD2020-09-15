package by.it.fedorinhyk.jd01_14;

import java.io.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static final String FILE_DATA = "text.txt";
    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";
    private static final String RESULT_TASK_B = "resultTaskB.txt";

    private static String getpath(Class<?> classname) {
        String packagename = classname.getPackage().getName().replace(".", File.separator).concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC + File.separator + packagename;
    }

    public static void main(String[] args) {
        String filename = getpath(TaskB.class) + FILE_DATA;
        int wordssum=0;
        int signssum=0;
        PatternsMatchers(filename, wordssum, signssum);

    }

    private static void PatternsMatchers(String filename, int wordssum, int signssum) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String text=reader.readLine();
            while (text != null){
                Pattern pwords = Pattern.compile("[а-яА-ЯёЁ]+");
                Pattern psigns = Pattern.compile("[?!,:.-;\\.{3}]");
                Matcher words = pwords.matcher(text);
                Matcher signs = psigns.matcher(text);
                while (words.find()){
                    wordssum++;
                }
                while (signs.find()){
                    signssum++;
                }
                text=reader.readLine();
            }
            System.out.printf("words=%3d, punctuation marks=%2d", wordssum, signssum);
            String result=getpath(TaskB.class)+RESULT_TASK_B;;
            print(result, wordssum, signssum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void print(String resultTaskB, int wordssum, int signssum) {
        PrintWriter writer=null;
        try {
            writer = new PrintWriter(resultTaskB);
            writer.printf("words=%3d, punctuation marks=%2d", wordssum, signssum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(writer)) {
                writer.close();
            }
        }
    }
}
