package by.it.hutnik.jd01_08;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector (Vector vector) {
        this.value = vector.value;
    }

//    Vector (String strVector) {
//        this.value = Double.parseDouble(strVector);
//    }
}
