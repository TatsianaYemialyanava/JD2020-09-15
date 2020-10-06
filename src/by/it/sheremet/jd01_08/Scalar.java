package by.it.sheremet.jd01_08;

class Scalar extends Var {
    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {

        this.value = value;
    }



    Scalar(String str){
        this.value=Double.parseDouble(str);
    }

    Scalar(Scalar scalar){

        this.value=scalar.value;
    }



    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) {
        if(other instanceof Scalar){
            Scalar otherScalar = (Scalar) other;
            double sum = this.value+otherScalar.value;
            Scalar res = new Scalar(sum);
            return res;
        }
        else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Scalar){
            Scalar otherScalar = (Scalar) other;
            double sub = this.value-otherScalar.value;
            Scalar res = new Scalar(sub);
            return res;
        }
        else
            return other.sub(this).mul(new Scalar(-1));

    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            Scalar otherScalar = (Scalar) other;
            double mul = this.value * otherScalar.value;
            Scalar result = new Scalar(mul);
            return result;
        }
        else return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            Scalar otherScalar = (Scalar) other;
            double div = this.value / otherScalar.value;
            Scalar result = new Scalar(div);
            return result;
        }
        else
            return super.div(other);
    }
}
