package by.it.dobrodey.jd01_07;

import java.util.Arrays;

public class Vector extends Var {
    /**
     *  На уровень Bразработайте для класса Var наследника Vectorс тремя конструкторами:
     *  1. Из массива{1.0, 2.0, 4.0} сигнатура конструктора Vector(double[ ] value)
     *  2. Из такой же точно переменной сигнатура конструктора Vector(Vector vector)
     *  3. Из строки вида  {1.0, 2.0, 4.0} сигнатура конструктора Vector(String strVector)
     *   Переопределите метод String toString()так, чтобы он возвращал строку вида {1.0, 2.0, 4.0}
     */

    private double [] value;

    protected Vector(double[ ] value){ this.value = Arrays.copyOf(value,value.length);}

    protected Vector(Vector vector){
        double[] newValue = vector.value;
        this.value = Arrays.copyOf(newValue,newValue.length);
    }

    protected Vector(String strVector){
        String line = strVector.replace("{","");
        line = line.replace("}","");
        line = line.replace(" ","");
        line = line.trim();                        //убираем пробелы в конце
        String[] strArray = line.split(",");    // переыодмс стороку в массив строк
        double[] array = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Double.parseDouble(strArray[i]);
        this.value = array;
    }}

    public String toString(){
        StringBuilder out = new StringBuilder();
        out.append('{');
        String delimiter="";
        for (double element : value) {
            out.append(delimiter).append(element);
            delimiter=", ";
        }
        out.append('}');
        return out.toString();
    }

    }




