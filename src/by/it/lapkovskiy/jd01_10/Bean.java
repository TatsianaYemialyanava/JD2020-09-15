package by.it.lapkovskiy.jd01_10;

public class Bean {

    double sum(int a, int b) {
        return a + b;
    }
    @Param(a = 3, b = 6)
    static double max(int a, int b) {
        return a > b ? a : b;
    }
    @Param(a = 3, b = 6)
    static double min(int a, int b) {
        return a < b ? a : b;
    }
    @Param(a = 3, b = 6)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
