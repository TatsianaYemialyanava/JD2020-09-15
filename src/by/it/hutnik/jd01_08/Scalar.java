package by.it.hutnik.jd01_08;

class Scalar extends Var {

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    @Override
    public Var add(Var other) {
        return super.add(other);
    }

    Scalar (String strScalar) { this.value = Double.parseDouble(strScalar); }
    Scalar (Scalar scalar) { this.value = scalar.value; }


    @Override
    public String toString() {
        return Double.toString(value);
    }
}
