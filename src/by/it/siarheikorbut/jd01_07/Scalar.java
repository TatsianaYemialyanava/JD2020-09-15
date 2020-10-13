package by.it.siarheikorbut.jd01_07;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1TJnuaS3yKKmJURuLfRdT_3q1cc7uf8oU/view?usp=sharing">Задание JD01_07 ( A )</a>
 */

//Создание дочернего от класса Var класса Scalar.
public class Scalar extends Var {

    //Обьявление приватной финализированной переменной value.
    private final double value;

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
}
