package by.it.yemialyanava.jd01_07;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    double [][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix){
        this.value = new double[matrix.value.length][matrix.value[0].length];
        for (int i = 0; i < matrix.value.length; i++) {
            for (int j = 0; j < matrix.value[i].length; j++) {
                this.value[i][j] = matrix.value[i][j];
            }
        }
    }

    Matrix(String strMatrix){
        String cuttedString = strMatrix.substring(1,strMatrix.length()-1);
        Pattern patternSings = Pattern.compile("\\{[1-9.0,]+\\}");
        Matcher matchSings = patternSings.matcher(cuttedString);
        double[][] tempValue = new double[0][];
        int rowcount = 0;
        while (matchSings.find()){
            String line = matchSings.group();
            String cuttedLine = line.substring(1, line.length() -1);
            String[] arrayString = cuttedLine.split(",");
            double[] arrayFromLine = new double[arrayString.length];
            for (int i = 0; i < arrayString.length; i++) {
                arrayFromLine[i] = Double.parseDouble(arrayString[i]);
            }

            tempValue = Arrays.copyOf(tempValue, tempValue.length+1);
            tempValue[rowcount] = arrayFromLine;
            rowcount++;
        }
        this.value = tempValue;
    }


    @Override
    public String toString() {
        StringBuilder writterStrMatrix = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            writterStrMatrix.append("{");
            for (int j = 0; j < value[0].length; j++) {
                writterStrMatrix.append(value[i][j]);
                if (j != value[0].length-1){
                    writterStrMatrix.append(", ");
                }
            }
            writterStrMatrix.append("}");
            if (i != value.length-1){
                writterStrMatrix.append(", ");
            }
        }
        writterStrMatrix.append("}");
        return writterStrMatrix.toString();
    }
}
