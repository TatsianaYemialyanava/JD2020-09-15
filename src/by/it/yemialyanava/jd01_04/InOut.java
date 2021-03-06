package by.it.yemialyanava.jd01_04;

public class InOut {

    static double[] getArray(String line){
        String[] strArr = line.split(" ");
        double[]res = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i] = Double.parseDouble(strArr[i]);
        }
        return res;
    }

    static void printArray(double[ ] arr){
        for (double element:arr){
            System.out.print(element + " ");
        }
    }

    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            //v [i] = 20.3
            System.out.printf("%s[% -3d]=%-10.2f", name,i, arr[i]);
            if ((i + 1)%columnCount ==0 || i +1 ==arr.length){
                System.out.println();
            }
        }
    }
}


