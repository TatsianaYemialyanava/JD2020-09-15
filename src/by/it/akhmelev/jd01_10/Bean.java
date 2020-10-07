package by.it.akhmelev.jd01_10;

public class Bean {

    double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 5, b = 10)
    static double min(int a, int b) {
        return a < b ? a : b;
    }

    @Param(a = 5, b = 10)
    double max(int a, int b) {
        return a > b ? a : b;
    }

    @Param(a = 5, b = 10)
    static double avg(int a, int b) {
        return (a + b) / 2.0;
    }

}
