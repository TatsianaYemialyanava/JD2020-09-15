package by.it.kolesnikov.jd01_07;

public class Runner {
    public static void main(String[] args) {
        double[] vvv = {1, 2, 4, 8};
        Vector v1=new Vector(vvv);
        System.out.println(v1.toString());
        Scalar v2=new Scalar(3.1415);
        System.out.println(v2);
        Scalar v3=new Scalar(v2);
        System.out.println(v3);
    }
}
