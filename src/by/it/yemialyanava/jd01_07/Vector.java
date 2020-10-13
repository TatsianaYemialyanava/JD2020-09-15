package by.it.yemialyanava.jd01_07;
import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    Vector(double [] value){
        this.value = value;
    }

    Vector (Vector vector){
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    Vector(String strVector){
        String cuttedString = strVector.substring(1,strVector.length()-1);
        String[] arrayString = cuttedString.split(",");
        double[] vectorFromLine = new double[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            vectorFromLine[i] = Double.parseDouble(arrayString[i]);
        }
        this.value = vectorFromLine;
    }

    @Override
    public String toString() {
        StringBuilder writtedString = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            writtedString.append(delimiter).append(element);
            delimiter = ", ";
        }
        writtedString.append("}");
        return writtedString.toString();
    }
}
