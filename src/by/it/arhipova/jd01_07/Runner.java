package by.it.arhipova.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var v1 = new Scalar(3.1415);
        double[] vect = {1.0,2.0,4.0};
        Var v2 = new Vector(vect);
        System.out.println(v1);
        System.out.println(v2);
    }
}
