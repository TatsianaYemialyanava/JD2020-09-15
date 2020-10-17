package by.it.sheremet.jd01_09;

import java.util.Arrays;

class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = Arrays.copyOf(value, value.length);

    }

    Matrix(Matrix matrix) {
        double[][] mtr = matrix.value;
        this.value = Arrays.copyOf(mtr, mtr.length);
    }

    Matrix(String strMatrix) {
        String line = strMatrix;
        line = line.replaceAll("\\s+", "");
        line = line.replaceAll("\\{\\{", "");
        line = line.replaceAll("\\}\\}", "");
        String[] str = line.split("\\},\\{");
        String[][] newStr = new String[str.length][];
        for (int c = 0; c < str.length; c++) {
            newStr[c] = str[c].split(",");
        }
        this.value = new double[str.length][newStr[0].length];
        for (int i = 0; i < newStr.length; i++) {
            for (int j = 0; j < newStr[0].length; j++) {
                value[i][j] = Double.parseDouble(newStr[i][j]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("{");
        for (int i = 0; i < value.length; i++) {
            out.append("{");
            String delimiter = "";
            for (int j = 0; j < value[0].length; j++) {
                out.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            out.append("}");
            if (i < (value.length - 1)) {
                out.append(delimiter);
            }
        }
        out.append("}");
        return out.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
           Scalar otherScalar = (Scalar) other;
            double[][] sum = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < sum.length; i++) {
                sum[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[0].length; j++) {
                    sum[i][j] += otherScalar.getValue();
                }
            }
            Matrix result =new Matrix(sum);
            return result;

        } else if (other instanceof Matrix) {
            Matrix otherMatrix = (Matrix) other;
            double[][] sum = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < sum.length; i++) {
                sum[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[0].length; j++) {
                    sum[i][j] += otherMatrix.value[i][j];
                }
            }
            Matrix result = new Matrix(sum);
            return result;
        }
            return super.add(other);
    }






    @Override
    public
    Var sub(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[][] sub = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < sub.length; i++) {
                sub[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < sub.length; i++) {
                for (int j = 0; j < sub[0].length; j++) {
                    sub[i][j] -= otherScalar.getValue();
                }
            }
            Matrix result =new Matrix(sub);
            return result;
        } else if (other instanceof Matrix) {
            Matrix otherMatrix = (Matrix) other;
            double[][] sub = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < sub.length; i++) {
                sub[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < sub.length; i++) {
                for (int j = 0; j < sub[0].length; j++) {
                    sub[i][j] -= otherMatrix.value[i][j];
                }
            }
            Matrix result = new Matrix(sub);
            return result;
        }
        return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[][] mul = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < mul.length; i++) {
                mul[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < mul.length; i++) {
                for (int j = 0; j < mul[0].length; j++) {
                    mul[i][j] *= otherScalar.getValue();
                }
            }
            Matrix result = new Matrix(mul);
            return result;
        } else if (other instanceof Vector) {
            Vector otherVector = (Vector) other;
            double[][] mul = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < mul.length; i++) {
                mul[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < mul.length; i++) {
                for (int j = 0; j < mul[0].length; j++) {
                    mul[i][j] = mul[i][j] * otherVector.getValue()[j];
                }
            }
            double[] s = new double[mul.length];
            for (int i = 0; i < mul.length; i++) {
                for (int j = 0; j < mul[0].length; j++) {
                    s[i] += mul[i][j];
                }
            }
            Vector result = new Vector(s);
            return result;
        } else if (other instanceof Matrix) {
            Matrix otherMatrix = (Matrix) other;
            double[][] mul = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < mul.length; i++) {
                mul[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            double[][] s = new double[mul.length][otherMatrix.value[0].length];
            for (int i = 0; i < mul.length; i++) {
                for (int j = 0; j < mul[0].length; j++) {
                    for (int k = 0; k < otherMatrix.value.length ; k++) {
                        s[i][j] = s[i][j] + mul[i][k] * otherMatrix.value[k][j];
                    }

                }
            }
            Matrix result = new Matrix(s);
            return result;


        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }
}
