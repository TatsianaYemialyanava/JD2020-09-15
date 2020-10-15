package by.it.sheremet.culculator;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    public double[] getValue() {
        return value;
    }
    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);

    }

    Vector(Vector vector) {
        double[] tmp = vector.value;
        this.value = Arrays.copyOf(tmp, tmp.length);
    }

    Vector(String strVector) {
           String str = strVector.substring(1, strVector.length() - 1);
           String [] str1 =str.split(",");
            this.value = new double[str1.length];
            for (int i = 0; i < str1.length; i++) {
                value[i] = Double.parseDouble(str1[i]);
            }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[] sum = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] += otherScalar.getValue();
            }
            Vector result = new Vector(sum);
            return result;
        } else if (other instanceof Vector) {
            Vector otherVector = (Vector) other;
            double[] sum = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] += otherVector.value[i];
            }
            Vector result = new Vector(sum);
            return result;
        } else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[] sub = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] -= otherScalar.getValue();
            }
            Vector result = new Vector(sub);
            return result;
        } else if (other instanceof Vector) {
            Vector otherVector = (Vector) other;
            double[] sub = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] -= otherVector.value[i];
            }
            Vector result = new Vector(sub);
            return result;
        } else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[] mul = Arrays.copyOf(value, value.length);
            for (int i = 0; i < mul.length; i++) {
                mul[i] =mul[i] * otherScalar.getValue();
            }
            Vector result = new Vector(mul);
            return result;

        } else if (other instanceof Vector) {
            Vector otherVector = (Vector) other;
            double[] mul = Arrays.copyOf(value, value.length);
            for (int i = 0; i < mul.length; i++) {
                mul[i] *= otherVector.value[i];
            }
            double s=0;
            for (int i = 0; i < mul.length; i++) {
                s+=mul[i];
            }
            Scalar result=new Scalar(s);
            return result ;
        } else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[] div = Arrays.copyOf(value, value.length);
            for (int i = 0; i < div.length; i++) {
                div[i] = div[i] / otherScalar.getValue();
            }
            Vector result = new Vector(div);
            return result;

        } else
            return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append('{');
        String delimiter = "";
        for (double element : value) {
            out.append(delimiter).append(element);
            delimiter = ", ";
        }
        out.append('}');
        return out.toString();
    }
}


