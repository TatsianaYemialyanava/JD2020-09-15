package by.it.lapkovskiy.jd01_07;

import java.util.Arrays;

public class Matrix extends Var {
    double[][] value;
    Matrix(double[][] value){
        this.value = value;
    }
    Matrix(Matrix matrix){
        this.value = matrix.value;
    }
    Matrix(String strMatrix){
        strMatrix = strMatrix.replace("{{","");
        strMatrix = strMatrix.replace("}}","");
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
        this.value = Arrays.copyOf(arrDouble,arrDouble.length);
    }
    @Override
    public String toString() {
        String st ="{";
        for (int i = 0; i < value.length; i++) {
            st=st.concat("{");
            for (int j = 0; j < value[i].length-1; j++) {
                st=st.concat(value[i][j]+", ");
            }
            st+=value[i][value[i].length-1]+"}";
            if(i ==value.length-1) break;
            st=st.concat(" ,");
        }
        st+="}";
        return st;
    }
}
