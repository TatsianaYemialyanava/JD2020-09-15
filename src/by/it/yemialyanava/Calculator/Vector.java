package by.it.yemialyanava.Calculator;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector other) {
        double[] tmp = other.value;
        this.value = Arrays.copyOf(tmp, tmp.length);
    }

    Vector(String strValue) {
        String[] parts = strValue
                .replace("{", "")
                .replace("}", "")
                .split(",");
        value = new double[parts.length];
        for (int i = 0; i < parts.length; i++) {
            value[i] = Double.parseDouble(parts[i]);
        }
        this.value = value;
    }

    @Override
    public Var add(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            if ( ((Vector)other).value.length != this.value.length){
                throw new CalcException("the length of the vectors must be the same");
            }
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + ((Vector) other).value[i];
            }
            return new Vector(result);
        }else {
            throw new CalcException("it is impossible to add vector and matrix");
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            if ( ((Vector)other).value.length != this.value.length){
                throw new CalcException("the length of the vectors must be the same");
            }
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - ((Vector) other).value[i];
            }
            return new Vector(result);
        } else {
            throw new CalcException("it is impossible to subtract a matrix from a vector");
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue()==0){
                throw new CalcException("multiply by 0");
            }
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            if ( ((Vector)other).value.length != this.value.length){
                throw new CalcException("the length of the vectors must be the same");
            }
            double[] result = Arrays.copyOf(value, value.length);
            double sumResult = 0;
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * ((Vector) other).value[i];
                sumResult += result[i];
            }
            return new Scalar(sumResult);
        } else {
            throw new CalcException("it is impossible to multiply vector by matrix");
        }
    }

    @Override
    public Var div(Var other) throws CalcException{
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue()==0){
                throw new CalcException("division by 0");
            }
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] / ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else {
            throw new CalcException("dividing a vector by a vector or a vector by a matrix is impossible");
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            out.append(delimiter).append(element);
            delimiter = ", ";
        }
        out.append("}");
        return out.toString();
    }
}
