package by.it.sheremet.jd01_15;

/*Создайте матрицу 6 строк на 4 столбца из целых случайных чисел от -15 до 15 включительно.
         Выведите матрицу в текстовый файл matrix.txt, расположенный в папке задания jd01_15. При выводе для
        каждого числа нужно предусмотреть для него три знакоместа, после чисел – один пробел.
         Прочитайте файл и покажите его в консоли. Класс Scanner использовать нельзя.*/

public class TaskA {
    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                matrix[i][j]= -15 +(int) (Math.random()*15);
                System.out.println(matrix[i][j]);
            }
        }
    }
}
