package by.it.girovka.jd3;

/**
 * @author Girovka
 * @see <a href=http://bit.ly/jd2020-09-15 target=_blank>
 *     Задание</a>
 */
public class InOut {
    /**
     *  @author Girovka
     *  @see <a href=http://bit.ly/jd2020-09-15 target=_blank>
     *  Задание</a> Метод преобразования строки в массив
     * @param line -Входная строка (с числами)
     * @return Возвращаемый массив действительных чисел
     */
    static double[ ] getArray(String line){

        String [] strArray = line.split(" ");
        double[] array = new double [strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Double.parseDouble(strArray[i]);
        }
        return array;
    }
    /**
     * Метод вывода массива на консоль
     * @param arr - входной массив
     */
    static void printArray(double[ ] arr){
        for( double element : arr){
            System.out.print(element+" ");
        }
        System.out.println();
    }
     static void printArray(double[ ] arr, String name, int columnCount){
         for (int i = 0; i < arr.length; i++) {
             System.out.printf("%s[% -3d]=%-8.3f",name,i,arr[i]);
             if ((i + 1)%columnCount==0 || i==arr.length-1){
                 System.out.println();
             }
         }


     }
}
