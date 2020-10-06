package by.it.dobrodey.jd01_07;

public class Runner {
    public static void main(String[] args){
        Var s1 = new Scalar(3.1415);
        System.out.println(s1);
        Scalar s2 = new Scalar("3.1415");
        System.out.println(s2);
        Var s3 = new Scalar(s2);
        System.out.println(s3);

        double [] vector = {1, 2, 4};

        Vector v1 = new Vector(vector);
        System.out.println(v1);
        Var v2 = new Vector(v1);
        System.out.println(v1);
        Var v3 = new Vector("{1.0, 2.0, 4.0}");
        System.out.println(v3);

        double [][] matrix = { { 1.0, 2.0 },  { 3.0, 4.0 } };

        Matrix m1 = new Matrix(matrix);
        System.out.println(m1);
        Var m2 = new Matrix(m1);
        System.out.println(m1);
        Var m3 = new Matrix("{ { 1.0, 2.0 },  { 3.0, 4.0 } }");
        System.out.println(m3);



    }
}
