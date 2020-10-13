package by.it.yemialyanava.jd01_10;

public class Bean {
    double sum(int a, int b){
        return a+b;
    }

    @Param(a=5, b=10)
    static double max(int a, int b){
        return a>b?a:b;
    }

    @Param(a=8, b=2)
    double min(int a, int b){
        return a>b?b:a;
    }

    @Param(a=6, b=45)
    static double avg(int a, int b){
        return (a+b)/2.0;
    }
}
