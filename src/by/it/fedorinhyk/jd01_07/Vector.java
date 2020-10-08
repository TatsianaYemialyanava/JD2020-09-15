package by.it.fedorinhyk.jd01_07;

import java.util.Arrays;

class Vector extends Var{
    private double[] value;

    Vector (double[]value){
        this.value=value;
    }

    Vector (Vector vector){
        double[] tmp = vector.value;
        this.value = Arrays.copyOf(tmp,tmp.length);
    }
    Vector (String strVector) {
        String[] str = strVector.replace('{',' ').replace('}',' ')
                .trim().split(",");
        value=new double[str.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(str[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder sbv=new StringBuilder("{");
        String delimiter="";
        for (double element : value){
            sbv.append(delimiter).append(element);
            delimiter=", ";
        }
        sbv.append("}");
        return sbv.toString();
    }
}
