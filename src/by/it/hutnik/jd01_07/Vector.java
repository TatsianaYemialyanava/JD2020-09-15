package by.it.hutnik.jd01_07;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;
    Vector(double[] value) {
        this.value = value;
    }
    Vector (Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector){
        strVector = strVector.replace("{","")
                .replace("}","");
        String[] arrVec = strVector.split(",");
        double[] arrDb = new double[arrVec.length];
        for (int i = 0; i < arrVec.length; i++) {
            arrDb[i] = Double.parseDouble(arrVec[i]);
        }
        value = Arrays.copyOf(arrDb, arrDb.length);
    }

    @Override
    public String toString() {
        String str = "{";
        for (int i = 0; i < value.length-1; i++) {
            str+= value[i] + ", ";
        }
        str+= value[value.length-1] + "}";
        return str;
    }

}
