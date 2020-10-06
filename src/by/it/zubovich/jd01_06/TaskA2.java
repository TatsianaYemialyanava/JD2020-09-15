//package by.it.zubovich.jd01_06;
//
//import java.util.Arrays;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class TaskA2 {
//    private static String[] uniqueWords = {};
//    private static String[] counters = {};
//    public static void main(String[] args) {
//        System.out.println(Poem.text);
//        StringBuilder text = new StringBuilder(Poem.text);
//        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]+");
//        Matcher matcher = pattern.matcher(text);
//        while (matcher.find()) {
//            String word = matcher.group();
//            processOneWord (word);
//        }
//        System.out.println(text);
//    }
//
//    private static void processOneWord(String word) {
//        for (int i = 0; i < uniqueWowds.length; i++) {
//            if (uniqueWowds[i].equals(word)){
//                counters[i]++;
//                return;
//        }
//    }
//        uniqueWowds = Arrays.copyOf(uniqueWowds,uniqueWowds.length+1);
//        counters = Arrays.copyOf();
//}
//}
