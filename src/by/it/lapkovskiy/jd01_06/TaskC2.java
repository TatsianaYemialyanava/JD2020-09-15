package by.it.lapkovskiy.jd01_06;

public class TaskC2 {

    public static void main(String[] args) {
       // System.out.println(slow(Poem.text));
        System.out.println(fast(Poem.text));
    }

    static String slow(String poem) {
        prev = 1;
        String st = "";
        String[] words = poem.split("[^а-яА-ЯёЁ]+");
        while (st.length() < 100000) {
            st = st.concat(words[random(words.length)]).concat(" ");
        }
        return st;
    }

    static String fast(String poem) {
        StringBuilder sb = new StringBuilder();
        prev = 1;
        String[] words = poem.split("[^а-яА-ЯёЁ]+");
        while (sb.length() < 100000) {
            sb.append(words[random(words.length)]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static int prev;
    public static int xz = 1;

    static int random(int b) {
        prev =  (xz * prev + 10) % b;
        return prev;
    }
}
