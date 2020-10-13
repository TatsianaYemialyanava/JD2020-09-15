package by.it.yemialyanava.calculator;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    Vector(String strVector) {
        String cuttedString = strVector.substring(1, strVector.length() - 1);
        String[] arrayString = cuttedString.split(", ?");
        double[] vectorFromLine = new double[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            vectorFromLine[i] = Double.parseDouble(arrayString[i]);
        }
        this.value = vectorFromLine;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + ((Vector) other).value[i];
            }
            return new Vector(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - ((Vector) other).value[i];
            }
            return new Vector(result);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            double[] result = Arrays.copyOf(value, value.length);
            double sumResult = 0;
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * ((Vector) other).value[i];
                sumResult += result[i];
            }
            return new Scalar(sumResult);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] / ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else {
            return super.div(other);
        }
    }

    @Override
    public String toString() {
        StringBuilder writtedString = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            writtedString.append(delimiter).append(element);
            delimiter = ", ";
        }
        writtedString.append("}");
        return writtedString.toString();
    }
}
