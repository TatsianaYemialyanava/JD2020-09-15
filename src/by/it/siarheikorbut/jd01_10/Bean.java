package by.it.siarheikorbut.jd01_10;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1NWv3k35f7iqw1vwxeZLH85PcjVS1L_6X/view?usp=sharing">Задание JD01_10 ( A2 )</a>
 */

public class Bean {
    //Создание метода вычисление суммы.
    @Param(a = 3, b = 4)
    static double sum(int a, int b) {
        return a + b;
    }

    //Создание метода вычисления среднего арифметического.
    @Param(a = 3, b = 4)
    static double avg(int a, int b) {
        return (a + b) / 2.0;
    }

    //Создание метода вычисления минимума.
    @Param(a = 3, b = 4)
    double min(int a, int b) {
        return Math.min(a, b);
    }

    //Создание метода вычисления максимума.
    double max(int a, int b) {
        return Math.max(a, b);
    }
}
