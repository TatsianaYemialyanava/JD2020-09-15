package by.it.moiseyenko.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    private static String[] uniqueSentence = {};
    private static int[] counters = {};


    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern ptrn = Pattern.compile("([^.!?]+(.{2,}[а-яё])?[^.!?]+)[.!?]");
        Matcher match = ptrn.matcher(text);

        while (match.find()) {
            String sentence = match.group();
            sentence = sentence.replaceAll("\n"," ");
            sentence = sentence.replaceAll("\\s*[.,;:?!-]+\\s*", " ");

            sentence = sentence.trim();
            lengthSentence(sentence);
        }

        Arrays.sort(counters);

        for (int i = 0; i < counters.length; i++) {
            for (int i1 = 0; i1 < uniqueSentence.length; i1++) {

                if (counters[i]==uniqueSentence[i1].length()){
                    System.out.printf(uniqueSentence[i1]+"\n");
                    uniqueSentence[i1] = "a";i1 = uniqueSentence.length-1;
                }
            }

        }
    }

    private static void lengthSentence(String sentence) {
        counters = Arrays.copyOf(counters, counters.length + 1);
        counters[counters.length - 1] = sentence.length();
        uniqueSentence = Arrays.copyOf(uniqueSentence, uniqueSentence.length + 1);
        uniqueSentence[uniqueSentence.length - 1] = sentence;

    }


}
