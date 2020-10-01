package by.it.akhmelev.jd01_06;

import java.util.Random;

public class TaskC2 {
    public static void main(String[] args) {
        TaskC2 app = new TaskC2();
        System.out.println(slow(Poem.text));
        System.out.println(fast(Poem.text));
    }

    private static final long START_TIME=System.nanoTime();

    static String slow(String text){
        String[] words = text.split("[^а-яА-ЯёЁ]+");
        String out="";
        Random random = new Random(START_TIME);
        while (out.length()<100000){
            out=out.concat(words[random.nextInt(words.length)]).concat(" ");
        }
        return out;
    }

    static String fast(String text){
        String[] words = text.split("[^а-яА-ЯёЁ]+");
        StringBuilder out = new StringBuilder("");
        Random random = new Random(START_TIME);
        while (out.length()<100000){
            out=out.append(words[random.nextInt(words.length)]).append(" ");
        }
        return out.toString();
    }


}
