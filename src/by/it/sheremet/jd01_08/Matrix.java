package by.it.sheremet.jd01_08;

import java.util.Arrays;

class Matrix extends Var { private double [][] value;

        Matrix(double[ ][ ] value){
            this.value= Arrays.copyOf(value, value.length);

        }

    Matrix(Matrix matrix){
            double [][] mtr=matrix.value;
            this.value=Arrays.copyOf(mtr, mtr.length);
    }

    Matrix(String strMatrix){
            String line=strMatrix;
            line=line.replaceAll("\\s+","");
            line =line.replaceAll("\\{\\{", "");
            line = line.replaceAll("\\}\\}","");
            String [] str = line.split("\\},\\{");
            String [][] newStr = new  String [str.length][];
        for (int c = 0; c < str.length; c++) {
             newStr[c]=str[c].split(",");
        }
            this.value= new double[str.length][newStr[0].length];
        for (int i = 0; i <newStr.length ; i++) {
            for (int j = 0; j <newStr[0].length ; j++) {
                value [i][j]=Double.parseDouble(newStr[i][j]);
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("{");
        for (int i = 0; i < value.length; i++) {
            out.append("{");
            String delimiter = "";
            for (int j = 0; j < value[0].length; j++) {
                out.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            out.append("}");
            if (i < (value.length - 1)) {
                out.append(delimiter);
            }
        }
        out.append("}");
        return out.toString();
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
