package by.it.frolova.jd01_10;

public class Bean {
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 5, b = 10)
    static double max(int a, int b) {
        return Math.max(a, b);
    }

    @Param(a = 5, b = 10)
    double min(int a, int b) {
        return Math.min(a, b);
    }

    @Param(a = 5, b = 10)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }

}
