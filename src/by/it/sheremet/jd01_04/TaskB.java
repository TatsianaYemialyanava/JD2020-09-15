package by.it.sheremet.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int Str=0;
        int sumStr=0;
        double averStr=0;
        int averStr1=0;
        double averStr2=0;
        int n;
        n=sc.nextInt();
        String[] personArr=new String[n];
        Scanner scanner=new Scanner(System.in);
        for (int i = 0; i <=personArr.length-1; i++) {
            personArr[i]=scanner.nextLine();
        }
        int[][] moneyArr=new int[n][4];
        Scanner scan=new Scanner(System.in);
        for (int i = 0; i < personArr.length; i++) {
            System.out.println("Введите зарплату для "+personArr[i]);
            for (int j = 0; j < moneyArr[i].length; j++) {
                moneyArr[i][j] = scan.nextInt();
                sumStr=moneyArr[i][j]+sumStr;
                averStr=sumStr/(personArr.length*4);
                averStr=averStr*100;
                averStr1 =(int) Math.round(averStr);
                averStr2 = averStr1/100;
            }
        }
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%n", "фамилия", "1квартал", "2квартал", "3квартал", "4квартал","итого");
        System.out.printf("-------------------------------------------------------%n");
        for (int l = 0; l < personArr.length ; l++) {
            Str=moneyArr[0+l][0]+moneyArr[0+l][1]+moneyArr[0+l][2]+moneyArr[0+l][3];
            System.out.printf("%-10s%-10d%-10s%-10s%-10s%-10s%n",personArr[0+l],moneyArr[0+l][0],moneyArr[0+l][1],moneyArr[0+l][2],moneyArr[0+l][3],Str);
        }
        //String str=String.format("%-10.4f",averStr);
        System.out.printf("-------------------------------------------------------%n");
        System.out.printf("%-10s%-10d%n","Итого",sumStr);
        System.out.printf("%-10s%-10.4f","Средняя",averStr2);

    }
}
