package by.it.fedorinhyk.jd01_07;

import java.util.Arrays;

class Matrix extends Var {
    private double [][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix (Matrix matrix){
        double[][] mat = matrix.value;
        this.value = Arrays.copyOf(mat, mat.length);
    }

    Matrix (String strMatrix){
        String mat = strMatrix;
        mat = mat.replaceFirst("\\{\\{","").replaceFirst("}}","");
        String[] matvec = mat.split("},\\{");
        String[][] matstr = new String[matvec.length][];
        for (int i = 0; i < matvec.length; i++) {
            matstr[i] = matvec[i].split(",");
        }
        double[][] fin = new double[matvec.length][matstr[0].length];
        for (int i = 0; i < matstr.length; i++) {
            for (int j = 0; j < matstr[0].length; j++) {
                fin[i][j] = Double.parseDouble(matstr[i][j]);
            }
        }
        this.value = fin;
    }

    @Override
    public String toString() {
        StringBuilder sbv = new StringBuilder();
        sbv.append("{");
        for (int i = 0; i < value.length ; i++) {
            sbv.append("{");
            String delimiter="";
            for (int j = 0; j < value[0].length; j++) {
                sbv.append(delimiter).append(value[i][j]);
                delimiter=",";
            }
            sbv.append("}");
            if(i< (value.length-1)){
                sbv.append(delimiter);
            }
        }
        sbv.append("}");
        return sbv.toString();
    }

}
