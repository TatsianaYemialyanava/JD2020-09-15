package by.it.yemialyanava.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        step1(n);
        step2(arr);
        //step3(arr);
    }

    private static int[][] step1(int n) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) ((Math.random() * (2 * (n + 1)) - n - 1));
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }
        return arr;
    }

    private static int step2(int[][] arr) {
        int sum = 0;
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0) {
                    k = j;
                    break;
                }
                for (j = k + 1; j < arr[i].length; j++) {
                    if (arr[i][j] > 0) {
                        break;
                    } else {
                        sum += arr[i][j];
                    }
                }

            }

        }
        System.out.println(sum);
        return sum;
    }



    /*private static int[][] step3(int[][] arr) {
        int i =0;
        int j = 0;
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }
        return*/


}
