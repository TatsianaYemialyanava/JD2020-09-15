package by.it.sheremet.jd01_04;

public class Helper {
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
    
}



