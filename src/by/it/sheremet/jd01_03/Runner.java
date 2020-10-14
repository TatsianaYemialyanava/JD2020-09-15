package by.it.sheremet.jd01_03;

import java.util.Scanner;


public class Runner {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String matV = sc.nextLine();
        String matM = sc.nextLine();


        double[] array = InOut.getArray(str);
        double[][] matrix = InOut.getMatrix(matV);
        double[][] matrixLeft = InOut.getMatrix(matV);
        double[][] matrixRight = InOut.getMatrix(matM);


        InOut.printArray(array);
        InOut.printArray(array,"V",3);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
        Helper.mul(matrix,array);
        Helper.mul(matrixLeft,matrixRight);

    }

}
