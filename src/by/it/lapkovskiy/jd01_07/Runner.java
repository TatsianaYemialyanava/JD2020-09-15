package by.it.lapkovskiy.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar v1 = new Scalar(3.1415);
        Scalar v2 = new Scalar(v1);
        Scalar v3 = new Scalar("3.1415");
        Vector d = new Vector("{34.0, 534.0, 5345.0, 55.0}");
        String st = "{{1,2},{3,4}}";
        Matrix m = new Matrix(st);
        System.out.println(st.toString());

    }

}
