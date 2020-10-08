package by.it.hutnik.jd01_08;

class Scalar extends Var {

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        }
        return super.add(other);
    }

    Scalar (String strScalar) { this.value = Double.parseDouble(strScalar); }
    Scalar (Scalar scalar) { this.value = scalar.value; }


    @Override
    public String toString() {
        return Double.toString(value);
    }
}
