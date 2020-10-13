package by.it.moiseyenko.jd01_07;

import java.util.Arrays;

public class Matrix extends Var {
    /**
     *  На уровень Cразработайте для класса Varнаследника Matrixс тремя конструкторами:
     *  1. Из массива{ { 1.0, 2.0 },  { 3.0, 4.0 } } сигнатура Matrix(double[ ][ ]  value)
     *  2. Из такой же точно переменной сигнатура Matrix(Matrix matrix)
     *  3. Из строки вида  { { 1.0, 2.0 },  { 3.0, 4.0 } } сигнатура Matrix(String strMatrix)
     *   Переопределите метод String toString()так, чтобы он возвращал строку вида { { 1.0, 2.0 },  { 3.0, 4.0 } }
     */
    private double[][]value;

    protected Matrix(double[ ][ ]  value){
        this.value = value;
    }

    protected Matrix(Matrix matrix){
        double[][] newMatrix = matrix.value;
        for (int i = 0; i < matrix.value.length; i++) {
            newMatrix[i] = Arrays.copyOf(matrix.value[i], matrix.value[i].length);
        }
        this.value = newMatrix;

    }
    protected Matrix(String strMatrix){
        /**
         * { { 1.0, 2.0 },  { 3.0, 4.0 } }
         */
        String line = strMatrix.trim();
        line = line.replaceAll("\\s+","");
        line = line.replaceFirst("\\{\\{","");
        line = line.replaceFirst("\\}\\}","");
        String[] lineNew = line.split("\\},\\{");
        String[][] elementNew = new String[lineNew.length][];
        for (int i1 = 0; i1 < lineNew.length; i1++) {
            elementNew[i1] = lineNew[i1].split(",");
        }

        double[][] array = new double[lineNew.length][elementNew[0].length];
        for (int i = 0; i < elementNew.length; i++) {
            for (int j = 0; j < elementNew[0].length; j++) {
                array[i][j] = Double.parseDouble(elementNew[i][j]);
            }

        }
        this.value = array;

    }



    public String toString(){
        //Переопределите метод String toString()так, чтобы он возвращал строку вида { { 1.0, 2.0 },  { 3.0, 4.0 } }
        StringBuilder out = new StringBuilder();
        out.append("{");
        for (int i = 0; i < value.length ; i++) {
            out.append(" {");
            String delimiter="";
            for (int j = 0; j < value[0].length; j++) {
                out.append(delimiter).append(value[i][j]);
                delimiter=", ";
            }
            out.append("}");
            if(i< (value.length-1)){out.append(delimiter);}
        }
        out.append(" }");
        return out.toString();
    }



}