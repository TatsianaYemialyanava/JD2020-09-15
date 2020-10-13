package by.it.lapkovskiy.calculator;


public class Scalar extends Var {
    public double value;

    @Override
    public String toString() {
        return String.valueOf(value);
    }
    Scalar(double value){
        this.value = Double.valueOf(value);
    }
    Scalar(Scalar scalar){
        value = Double.valueOf(scalar.value);
    }
    Scalar(String strScalar){
        value = Double.parseDouble(strScalar);
    }

    @Override
    public Var add(Var other) {
        if(other instanceof Scalar){
            double sum = this.value+((Scalar) other).value;
            return new Scalar(sum);
        }
        else {
            return  other.add(this);
        }
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Scalar){
            double sub = this.value-((Scalar) other).value;
            return new Scalar(sub);
        }
        else {
            return  new Scalar(-1).mul(other).add(this);
        }
    }

    @Override
    public Var mul(Var other) {
        if(other instanceof Scalar){
            double mul = this.value*((Scalar) other).value;
            return new Scalar(mul);
        }
        else {
            return  other.mul(this);
        }
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Scalar){
            double div = this.value/((Scalar) other).value;
            return new Scalar(div);
        }
        else {
            return  super.div(this);
        }
    }
}
