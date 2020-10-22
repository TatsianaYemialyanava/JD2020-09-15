package by.it.sheremet.jd01_14;

import java.io.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";
    private static final String RESULT_TASK = "resultTaskB.txt";
    public static final String TEXT_TXT = "text.txt";


    private static String getPath(Class<?> bClass) {
        String packageName = bClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC + File.separator + packageName;
    }

    public static void main(String[] args) {
        String fileText = getPath(TaskB.class) + TEXT_TXT;
        String filenameText = getPath(TaskB.class) + RESULT_TASK;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileText));
            int words=0;
            int zn=0;
            String line;
            while ((line=bufferedReader.readLine())!=null){
                line = line.replaceAll("\\.{3}",".");
                Pattern patternWords = Pattern.compile("[а-яА-ЯЁё]+");
                Matcher matcherWords = patternWords.matcher(line);
                while (matcherWords.find()){
                    words++;
                }
                Pattern patternZn = Pattern.compile("[-?!.,;:]");
                Matcher matcherZn = patternZn.matcher(line);
                while (matcherZn.find()){
                    zn++;
                }
            }
            System.out.println("words=" +words+ " punctuation marks=" +zn);
            printToFile(filenameText, words, zn);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printToFile(String filenameText, int words, int zn) {
        PrintWriter printWriter = null;
        try {
            printWriter=new PrintWriter(filenameText);
            printWriter.println("words=" +words+ " punctuation marks=" +zn);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(Objects.nonNull(printWriter)){
                printWriter.close();
            }
        }

    }
}



