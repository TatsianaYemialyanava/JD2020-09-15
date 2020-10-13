package by.it.dobrodey.jd01_10;

public class Bean {

    static double sum(int a, int b) {
        return a + b;
    }
    @Param(a=5,b =8)
    double max(int a, int b) {
        return a > b ? a : b;
    }
    @Param(a=4,b =6)
    static double min(int a, int b) {
        return a > b ? b : a;
    }

    @Param(a=6,b =2)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }

}
