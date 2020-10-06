package by.it.kolesnikov.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {

    private double[] value;

    public Vector(double[] value) {

        this.value = Arrays.copyOf(value,value.length);
    }

    public Vector(Vector other) {
        double[] tmp = other.value;
        this.value = Arrays.copyOf(tmp,tmp.length);
    }

    public Vector(String strVector){
        Pattern pattern = Pattern.compile("[{}]");
        Matcher matcher = pattern.matcher(strVector);
        while (matcher.find()) {
            strVector = matcher.replaceAll(" ");
        }
        double[] vec = new double[strVector.trim().split(",").length];
        for (int i = 0; i < strVector.trim().split(",").length; i++) {
            vec[i] = Double.parseDouble(strVector.trim().split(",")[i]);
        }
        this.value = vec;
    }

    @Override
    public String toString() {
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
