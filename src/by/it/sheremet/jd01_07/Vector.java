package by.it.sheremet.jd01_07;

import java.lang.reflect.Array;
import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);

    }

    Vector(Vector vector) {
        double[] tmp = vector.value;
        this.value = Arrays.copyOf(tmp, tmp.length);
    }

    Vector(String strVector) {
           String str = strVector.substring(1, strVector.length() - 1);
           String [] str1 =str.split(",");
            this.value = new double[str1.length];
            for (int i = 0; i < str1.length; i++) {
                value[i] = Double.parseDouble(str1[i]);
            }

    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append('{');
        String delimiter = "";
        for (double element : value) {
            out.append(delimiter).append(element);
            delimiter = ", ";
        }
        out.append('}');
        return out.toString();
    }
}


