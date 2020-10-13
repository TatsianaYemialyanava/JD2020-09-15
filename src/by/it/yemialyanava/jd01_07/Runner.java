package by.it.yemialyanava.jd01_07;

public class Runner {
    public static void main(String[] args) {
        //String vov = "3.1415";
        //Var v1 = new Scalar(vov);
        //double[] vector = {1.0, 5.0, 57.1};
        //String voyaz = "{1,2,34}";
        //Var v2 = new Vector(voyaz);
        //System.out.println(v1);
        //System.out.println(v2);
        String z ="{{1.0,2.0},{3.0,4.0}}";
        //double [][] d = {{1.0, 2.0, 3.0},{2.0, 3.0, 4.0}};
        Var v3 = new Matrix(z);
        System.out.println(v3);

    }
}
