package by.it.moiseyenko.jd01_01;

public class Main {

    public static void main(String[] args) {

        Hello hello=new Hello();
        hello.printslogan();
        hello.setSlogan("Привет мир");
        hello.printslogan();

        Args argObjekt=new Args(args);
        argObjekt.printArgs();
    }
}
