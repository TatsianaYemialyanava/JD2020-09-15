package by.it.siarheikorbut.calc;

import java.util.Arrays;

//Создание дочернего от класса Var класса Vector
public class Vector extends Var {

    //Обьявление приватного финализированного одномерного массива value.
    private final double[] VALUE;

    //Создание конструктора принимающего в себя массив value.
    Vector(double[] value) {
        this.VALUE = value;
    }

    //Создание конструктора принимающего в себя экземпляр класса Vector.
    Vector(Vector vector) {
        this.VALUE = vector.VALUE;
    }

    //Создание конструктора принимающего в себя строку и преобразующего её в массив чисел.
    Vector(String strVector) {
        String[] s1 = strVector.replaceAll("\\{", "").replaceAll("}", "").split(",");
        this.VALUE = new double[s1.length];
        for (int i = 0; i < s1.length; i++) {
            VALUE[i] = Double.parseDouble(s1[i].trim());
        }
    }

    //Переопределение метода toString для вывода одномерного массива.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : VALUE) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }

    //Метод сложения скаляра и вектора, вектора и вектора.
    @Override
    public Var add(Var other) throws CalcException {
        //Сложение скаляра и вектора.
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(VALUE, VALUE.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
            //Сложение вектора и вектора.
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(VALUE, VALUE.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).VALUE[i];
            }
            return new Vector(res);
        } else
            //Сложение вектора и матрицы является ошибкой.
            return super.add(other);
    }

    //Метод вычитания скаляра из вектора, вектора и вектора.
    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] sub = Arrays.copyOf(VALUE, VALUE.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] -= ((Scalar) other).getValue();
            }
            return new Vector(sub);
        } else if (other instanceof Vector) {
            double[] arr = new double[((Vector) other).VALUE.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = VALUE[i] - ((Vector) other).VALUE[i];
            }
            return new Vector(arr);
        } else {
            return super.sub(this);
        }
    }

    //Метод умножения скаляра и вектора, вектора и вектора.
    @Override
    public Var mul(Var other) throws CalcException {

        if (other instanceof Scalar) {
            double[] sub = Arrays.copyOf(VALUE, VALUE.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] *= ((Scalar) other).getValue();
            }
            return new Vector(sub);
        } else if (other instanceof Vector) {
            double arr = 0;
            for (int i = 0; i < VALUE.length; i++) {
                arr += VALUE[i] * ((Vector) other).VALUE[i];
            }
            return new Scalar(arr);
        } else {
            return super.mul(this);
        }
    }

    //Метод деления вектора на скаляр, вектора и вектора.
    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] sub = Arrays.copyOf(VALUE, VALUE.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] /= ((Scalar) other).getValue();
            }
            return new Vector(sub);

        } else {
            return super.div(this);
        }
    }
}