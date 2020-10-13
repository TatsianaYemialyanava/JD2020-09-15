package by.it.siarheikorbut.jd01_09;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1C-wHpUcHtxb-Qq0lfyExNQsYeKr3yIPh/view?usp=sharing">Задание JD01_09 ( A )</a>
 */

//Создание дочернего от класса Var класса Scalar.
public class Scalar extends Var {

    //Обьявление приватной финализированной переменной value.
    private final double value;
    public double getValue() {
        return value;
    }

    //Создание конструктора принимающего в себя переменную value.
    Scalar(double value) {
        this.value = value;
    }

    //Создание конструктора принимающего в себя экземпляр класса Scalar.
    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    //Создание конструктора принимающего в себя строку и преобразующего её в число.
    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    //Переопределение метода toString.
    @Override
    public String toString() {
        return Double.toString(value);
    }

    //Метод сложения скаляров.
    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        } else return other.add(this);
    }

    //Метод вычитания скаляров.
    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        } else return new Scalar(-1).mul(other).add(this);
    }

    //Метод умножения скаляров
    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double mul = this.value * ((Scalar) other).value;
            return new Scalar(mul);
        } else return other.mul(this);
    }

    //Метод деления скаляров.
    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);
        } else return super.div(other);
    }
}
