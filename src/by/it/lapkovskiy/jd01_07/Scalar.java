package by.it.lapkovskiy.jd01_07;

public class Scalar extends Var{
    Double value;
    @Override
    public String toString() {
        return value.toString();
    }
    Scalar(double value){
        this.value = value;
    }
    Scalar(Scalar scalar){
        value = scalar.value;
    }
    Scalar(String strScalar){
        value = Double.parseDouble(strScalar);
    }
}
