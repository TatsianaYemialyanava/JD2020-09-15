package by.it.sheremet.jd01_07;

import java.util.Arrays;

class  Matrix extends Var {
    private double [][] value;

        Matrix(double[ ][ ] value){
            this.value= Arrays.copyOf(value, value.length);

        }

    Matrix(Matrix matrix){
            double [][] mtr=matrix.value;
            this.value=Arrays.copyOf(mtr, mtr.length);
    }

    Matrix(String strMatrix){
            String line =strMatrix;
            line=line.replaceAll(" ","");
            line=line.replaceAll("\\{\\{","");
            line=line.replaceAll("\\}\\}","");
            String [] str =line.split("\\},\\{");
            String [][] newStr=new String[str.length][];
        for (int b = 0; b < str.length; b++) {
            newStr[b]=str[b].split(",");

        }
        this.value=new double[str.length][newStr[0].length];
        for (int i = 0; i <str.length ; i++) {
            for (int j = 0; j < newStr[0].length; j++) {
              this.value[i][j]=Double.parseDouble(newStr[i][j]);

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
}
