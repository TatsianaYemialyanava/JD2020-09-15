package by.it.hutnik.jd01_07;

public class Runner {

    public static void main(String[] args) {
        Vector vec = new Vector("{1.0, 2.0, 4.0}");
        Var v1 = new Scalar(3.1415);
        Var v2 = new Vector (vec);
        System.out.println(v1);
        System.out.println(v2);
    }
}

//    Scalar v1 = new Scalar(3.1415);
//    Scalar v2 = new Scalar(v1);
//    Scalar v3 = new Scalar("3.1415");
//    Vector d = new Vector("{34.0, 534.0, 5345.0, 55.0}");
//    String st = "{{1,2},{3,4}}";
//    Matrix m = new Matrix(st);
//    System.out.println(st.toString());