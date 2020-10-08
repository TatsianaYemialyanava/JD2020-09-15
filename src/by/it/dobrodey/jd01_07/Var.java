package by.it.dobrodey.jd01_07;

public abstract class Var {
    /**
     *На уровень A разработайте для класса Var наследника Scalar с тремя конструкторами:
     * 1. Из вещественного числа 3.1415 сигнатура конструктора Scalar(double value)
     * 2. Из такой же точно переменной сигнатура конструктора Scalar(Scalar scalar)
     * 3. Из строки вида 3.1415 сигнатура конструктора Scalar(String strScalar)
     *  Переопределите метод String toString() так, чтобы он возвращал строку вида 3.1415
     *    *
     */
    public String toString() {
        return "abstract Var";
    }
}




