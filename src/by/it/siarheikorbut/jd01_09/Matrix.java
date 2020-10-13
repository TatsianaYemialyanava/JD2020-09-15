package by.it.siarheikorbut.jd01_09;

import java.util.Arrays;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1C-wHpUcHtxb-Qq0lfyExNQsYeKr3yIPh/view?usp=sharing">Задание JD01_09 ( C )</a>
 */

//Создание дочернего от класса Var класса Vector
public class Matrix extends Var {

    //Обьявление приватного финализированного двумерного массива value.
    private final double[][] VALUE;

    //Создание конструктора принимающего в себя массив value.
    Matrix(double[][] value) {
        this.VALUE = value;
    }

    //Создание конструктора принимающего в себя экземпляр класса Matrix.
    Matrix(Matrix matrix) {
        this.VALUE = matrix.VALUE;
    }

    //Создание конструктора принимающего в себя строку и преобразующего её в двумерный массив чисел.
    Matrix(String strMatrix) {
        strMatrix = strMatrix.replace("{{", "");
        strMatrix = strMatrix.replace("}}", "");
        String[] str = strMatrix.split("},\\{");

        String[][] st = new String[str.length][];
        for (int i = 0; i < str.length; i++) {
            st[i] = str[i].split(",");
        }
        double[][] arrDouble = new double[st.length][st[0].length];
        for (int i = 0; i < st.length; i++) {
            for (int j = 0; j < st[i].length; j++) {
                arrDouble[i][j] = Double.parseDouble(st[i][j]);
            }
        }
        this.VALUE = Arrays.copyOf(arrDouble, arrDouble.length);
    }

    //Переопределение метода toString для вывода двумерного массива.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < VALUE.length; i++) {
            double[] row = VALUE[i];
            if (i > 0) sb.append(", ");
            sb.append("{");
            for (int j = 0; j < row.length; j++) {
                if (j > 0)
                    sb.append(", ");
                sb.append(row[j]);
            }
            sb.append("}");
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) {
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }
}