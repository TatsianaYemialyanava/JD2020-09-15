package by.it.kolesnikov.jd01_14;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    static final String SRC = "src";
    static final String USER_DIR = "user.dir";

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        String text = getPath(TaskB.class)+"text.txt";
        File tex = new File(text);
        FileReader is = null;
        try {
            is = new FileReader(tex);
            while (is.read()!= -1) {         // чтение одного байта.
                System.out.print((char)is.read());
            }
            System.out.println(words);
            Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                String word = matcher.group();
                words.add(word);
            }
            for (int i =0; i< words.size(); i++) {
                System.out.print(words.get(i) + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(is!=null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
