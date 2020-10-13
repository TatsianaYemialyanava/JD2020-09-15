package by.it.yemialyanava.jd01_08;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    double[][] value;

    public double[][] getValue() {
        return value;
    }

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = copyMatrix(matrix.value);
    }

    public Matrix(String strMatrix) {
        String cuttedString = strMatrix.substring(1, strMatrix.length() - 1);
        Pattern patternSings = Pattern.compile("\\{([0-9]|[.]|,| )+\\}");
        Matcher matchSings = patternSings.matcher(cuttedString);
        double[][] tempValue = new double[0][];
        int rowcount = 0;
        while (matchSings.find()) {
            String line = matchSings.group();
            String cuttedLine = line.substring(1, line.length() - 1);
            String[] arrayString = cuttedLine.split(", ?");
            double[] arrayFromLine = new double[arrayString.length];
            for (int i = 0; i < arrayString.length; i++) {
                arrayFromLine[i] = Double.parseDouble(arrayString[i]);
            }
            tempValue = Arrays.copyOf(tempValue, tempValue.length + 1);
            tempValue[rowcount] = arrayFromLine;
            rowcount++;
        }
        this.value = tempValue;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] res = copyMatrix(getValue());
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            double[][] res = copyMatrix(getValue());
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] res = copyMatrix(getValue());
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            double[][] res = copyMatrix(getValue());
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] res = copyMatrix(getValue());
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector) {
            double[][] res = copyMatrix(getValue());
            double[] resVect = new double[res.length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                    resVect[i] = resVect[i] + res[i][j] * ((Vector) other).getValue()[j];
                }
            }
            return new Vector(resVect);
        } else if (other instanceof Matrix) {
            double[][] res = copyMatrix(getValue());
            double[][] mulpiplMatr = new double[res.length][((Matrix) other).value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).value.length; k++) {
                        mulpiplMatr[i][j] = mulpiplMatr[i][j] + res[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(mulpiplMatr);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder writterStrMatrix = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            writterStrMatrix.append("{");
            for (int j = 0; j < value[0].length; j++) {
                writterStrMatrix.append(value[i][j]);
                if (j != value[0].length - 1) {
                    writterStrMatrix.append(", ");
                }
            }
            writterStrMatrix.append("}");
            if (i != value.length - 1) {
                writterStrMatrix.append(", ");
            }
        }
        writterStrMatrix.append("}");
        return writterStrMatrix.toString();
    }

    public double[][] copyMatrix(double[][] arr) {
        double[][] result = new double[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result[i][j] = arr[i][j];
            }
        }
        return result;
    }
}
