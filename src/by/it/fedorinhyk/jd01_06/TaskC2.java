package by.it.fedorinhyk.jd01_06;

public class TaskC2 {
    public static void main(String[] args) {
        long start = System.nanoTime();
        String text = slow(Poem.text);
        long end =System.nanoTime();
        System.out.println(text);
        System.out.println((double)(end-start)/1000000000 + " sec");
        start = System.nanoTime();
        text = fast(Poem.text);
        end =System.nanoTime();
        System.out.println(text);
        System.out.println((double)(end-start)/1000000000 + " sec");
    }

    public static String slow(String text){
        String bigText = text;
        while (bigText.length() < 100000){
            bigText += String.format(" %s", text.trim());
        }
        return bigText;
    }
    public static String fast(String text) {
        StringBuilder bigText = new StringBuilder();
        bigText.append(text);
        while (bigText.length() < 100000) {
            bigText.append(String.format(" %s", text.trim()));
        }
        return bigText.toString();
    }
}


