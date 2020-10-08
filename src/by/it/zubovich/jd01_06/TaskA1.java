package by.it.zubovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        //System.out.println(Poem.text);
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            System.out.println(word + " " + matcher.start() + " " + matcher.end());
        }
        System.out.println(text);
    }
}
