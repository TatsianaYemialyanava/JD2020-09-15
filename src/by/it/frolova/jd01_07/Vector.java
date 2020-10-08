package by.it.frolova.jd01_07;
/* разработайте для класса Var наследника Vector с тремя конструкторами:
1. Из массива {1.0, 2.0, 4.0} сигнатура конструктора Vector(double[ ] value)
2. Из такой же точно переменной сигнатура конструктора Vector(Vector vector)
3. Из строки вида {1.0, 2.0, 4.0} сигнатура конструктора Vector(String strVector)
 Переопределите метод String toString() так, чтобы он возвращал строку вида {1.0, 2.0, 4.0}*/

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector vector) {
        double[] temp = vector.value;
        this.value = Arrays.copyOf(temp, temp.length);
    }

    public Vector(String strVector) {
        String[] str = strVector.substring(1, strVector.length() - 1).split(",");
        this.value = new double[str.length];
        for (int i = 0; i < str.length; i++) {
            value[i] = Double.parseDouble(str[i].trim());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
