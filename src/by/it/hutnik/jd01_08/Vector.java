package by.it.hutnik.jd01_08;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;
    Vector(double[] value) {
        this.value = value;
    }
    Vector (Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector){
        strVector = strVector.replace("{","")
                .replace("}","");
        String[] arrVec = strVector.split(",");
        double[] arrDb = new double[arrVec.length];
        for (int i = 0; i < arrVec.length; i++) {
            arrDb[i] = Double.parseDouble(arrVec[i]);
        }
        value = Arrays.copyOf(arrDb, arrDb.length);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double [] sum = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] = sum[i] + ((Scalar) other).getValue();
            }
            return new Vector(sum);
        }
        else if (other instanceof Vector) {
            double [] sum = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] = sum[i] + ((Vector)other).value[i];
            }
            return new Vector(sum);
        }
        else
            return super.add(other);

    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] sub = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] = sub[i] - ((Scalar) other).getValue();
            }
            return new Vector(sub);
        }
        else if (other instanceof Vector) {
            double[] sub = new double[((Vector) other).value.length];
            for (int i = 0; i < sub.length; i++) {
                sub[i] = value[i] - ((Vector) other).value[i];
            }
            return new Vector(sub);
        }
        return super.sub(other);
    }


    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] mul = Arrays.copyOf(value, value.length);
            for (int i = 0; i < mul.length; i++) {
                mul[i] = mul[i] * ((Scalar) other).getValue();
            }
            return new Vector(mul);
        }
        else if (other instanceof Vector) {
            double[] mul = Arrays.copyOf(value, value.length);
            double multi = 0;
            for (int i = 0; i < mul.length; i++) {
                multi += mul[i]  * ((Vector) other).value[i];
            }
            return new Scalar(multi);
        }
        return super.mul(other);
    }


    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] div = Arrays.copyOf(value, value.length);
            for (int i = 0; i < div.length; i++) {
                div[i] = div[i] / ((Scalar) other).getValue();
            }
            return new Vector(div);
        }
        return super.div(other);
    }


    @Override
    public String toString() {
        String str = "{";
        for (int i = 0; i < value.length-1; i++) {
            str+= value[i] + ", ";
        }
        str+= value[value.length-1] + "}";
        return str;
    }

}
