package by.it.fedorinhyk.calc;

import java.util.Arrays;

class Matrix extends Var {
    public double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        double[][] mat = matrix.value;
        this.value = Arrays.copyOf(mat, mat.length);
    }

    Matrix(String strMatrix) {
        String mat = strMatrix;
        mat = mat.replaceFirst("\\{\\{","")
                .replaceFirst("}}","").replaceAll("\\s+","");
        String[] matvec = mat.split("},\\{");
        String[][] matstr = new String[matvec.length][];
        for (int i = 0; i < matvec.length; i++) {
            matstr[i] = matvec[i].split(",");
        }
        double[][] fin = new double[matvec.length][matstr[0].length];
        for (int i = 0; i < matstr.length; i++) {
            for (int j = 0; j < matstr[0].length; j++) {
                fin[i][j] = Double.parseDouble(matstr[i][j]);
            }
        }
        this.value = fin;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[][] sum = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum.length; j++) {
                    sum[i][j] += otherScalar.getValue();
                }
            }
            return new Matrix(sum);
        } else if (other instanceof Matrix) {
            Matrix otherMatrix = (Matrix) other;
            double[][] sum = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum.length; j++) {
                    sum[i][j] += otherMatrix.value[i][j];
                }
            }
            return new Matrix(sum);
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[][] sub = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sub.length; i++) {
                for (int j = 0; j < sub.length; j++) {
                    sub[i][j] -= otherScalar.getValue();
                }
            }
            return new Matrix(sub);
        } else if (other instanceof Matrix) {
            Matrix otherMatrix = (Matrix) other;
            double[][] sub = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sub.length; i++) {
                for (int j = 0; j < sub.length; j++) {
                    sub[i][j] -= otherMatrix.value[i][j];
                }
            }
            return new Matrix(sub);
        } else return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[][] mul = Arrays.copyOf(value, value.length);
            for (int i = 0; i < mul.length; i++) {
                for (int j = 0; j < mul.length; j++) {
                    mul[i][j] *= otherScalar.getValue();
                }
            }
            return new Matrix(mul);
        } else if (other instanceof Vector) {
            Vector otherVector = (Vector) other;
            double[] mul = new double[value.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < otherVector.getValue().length; j++) {
                    mul[i] = mul[i] + value[i][j] * otherVector.getValue()[j];
                }
            }
            return new Vector(mul);
        } else if (other instanceof Matrix) {
            Matrix otherMatrix = (Matrix) other;
            double[][] mul = new double[otherMatrix.value.length][value[0].length];
            for (int i = 0; i < otherMatrix.value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    for (int k = 0; k < value.length; k++) {
                        mul[i][j] = mul[i][j] + otherMatrix.value[i][k] * value[k][j];
                    }
                }
            }
            return new Matrix(mul);
        } else return super.mul(other);
    }


    @Override
    public String toString() {
        StringBuilder sbv = new StringBuilder();
        sbv.append("{");
        for (int i = 0; i < value.length ; i++) {
            sbv.append("{");
            String delimiter="";
            for (int j = 0; j < value[0].length; j++) {
                sbv.append(delimiter).append(value[i][j]);
                delimiter=", ";
            }
            sbv.append("}");
            if(i< (value.length-1)){
                sbv.append(delimiter);
            }
        }
        sbv.append("}");
        return sbv.toString();
    }
}
