package by.it.hutnik.jd01_07;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector (Vector vector) {
        this.value = vector.value;
    }

    @Override
    public String toString() {
        return super.toString();
    }
//    Vector (String strVector) {
//        this.value = Double.parseDouble(strVector);
//    }
}
