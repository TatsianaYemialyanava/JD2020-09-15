package by.it.sheremet.jd01_03;

public class Helper{
    static double findMin(double[ ] arr){
        double min=arr[0];
        for (int i = 0; i < arr.length; i++) {
            min=Math.min(min,arr[i]);
        }
        System.out.println("Минимум массива Min=" +min);
        return min;
    }

    static double findMax(double[ ] arr){

        double max=arr[0];
        for (int i = 0; i < arr.length; i++) {
            max=Math.max(max,arr[i]);
        }
        System.out.println("Максимум массива Max=" +max);
        return max;

        }

    static void sort(double[ ] arr){
       boolean swap;
       int last=arr.length-1;
       do {
           swap = false;
              for (int j = 0; j <arr.length-1 ; j++) {
                    if (arr[j]>arr[j+1]){
                    double save=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=save;
                    swap=true;
              }
           }
            last--;
       }
       while (swap);
       return;


    }

    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double [] resMulvector = new double[matrix.length];
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < vector.length; j++) {
                resMulvector[i]+=matrix[i][j]*vector[j];
            }
        }
        return resMulvector;
    }

    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] mulMatrix = new double[matrixLeft.length][matrixRight[0].length];
            for (int i = 0; i <matrixLeft.length ; i++) {
                for (int j = 0; j < matrixRight[0].length; j++) {
                    for (int k = 0; k <matrixRight.length ; k++) {
                        mulMatrix[i][j] = mulMatrix[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                    }
                }
            }
        return mulMatrix;
    }

}



