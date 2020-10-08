package by.it.frolova.jd01_07;

public class Runner {
    public static void main(String[] args) {
        double[] arr = {1, 2, 3};
        double[][] matrix = {{1.0, 2.0}, {3.0, 4.0}};

        Scalar sc = new Scalar(3.1414);
        System.out.println(sc);
        Scalar sc2 = new Scalar("3.1414");
        System.out.println(sc2);
        Scalar sc3 = new Scalar(sc);
        System.out.println(sc3);
        Vector vec1 = new Vector(arr);
        System.out.println(vec1);
        Vector vec2 = new Vector(vec1);
        System.out.println(vec2);
        Vector vec3 = new Vector("{1.0, 2.0, 4.0}");
        System.out.println(vec3);
        Matrix m1 = new Matrix(matrix);
        System.out.println(m1);

        Matrix m2 = new Matrix(m1);
        System.out.println(m2);
        Matrix m3 = new Matrix("{ { 1.0, 2.0 }, { 3.0, 4.0 } }");
        System.out.println(m3);
    }
}
