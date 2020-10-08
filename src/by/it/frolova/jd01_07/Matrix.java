package by.it.frolova.jd01_07;

import java.util.Arrays;

/*разработайте для класса Var наследника Matrix с тремя конструкторами:
        1. Из массива { { 1.0, 2.0 }, { 3.0, 4.0 } } сигнатура Matrix(double[ ][ ] value)
        2. Из такой же точно переменной сигнатура Matrix(Matrix matrix)
        3. Из строки вида { { 1.0, 2.0 }, { 3.0, 4.0 } } сигнатура Matrix(String strMatrix)
         Переопределите метод String toString() так, чтобы он возвращал строку вида { { 1.0, 2.0 }, { 3.0, 4.0 } }
*/
public class Matrix extends Var {
    private double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        double[][] temp = matrix.value;
        this.value = Arrays.copyOf(temp, temp.length);
    }

    public Matrix(String strMatrix) {
        String str = strMatrix.replaceAll(" ", "");
        str = str.replaceFirst("\\{\\{", "");
        str = str.replaceFirst("\\}\\}", "");
        String[] strArr = str.split("\\},\\{");
        this.value = new double[strArr.length][];
        for (int i = 0; i < strArr.length; i++) {
            String[] t = strArr[i].split(",");
            value[i] = new double[t.length];
            for (int j = 0; j < value[i].length; j++) {
                value[i][j] = Double.parseDouble(t[j]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        String delimiter = ", ";
        for (int i = 0; i < value.length; i++) {
            sb.append("{ ");
            String delimiterIn = "";
            for (int j = 0; j < value[0].length; j++) {
                sb.append(delimiterIn).append(value[i][j]);
                delimiterIn = ", ";
            }
            sb.append(" }");
            if (i < value.length - 1) {
                sb.append(delimiter);
            }
        }
        sb.append(" }");
        return sb.toString();
    }
}
