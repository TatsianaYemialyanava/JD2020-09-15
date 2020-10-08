package by.it.kolesnikov.jd01_09;

public interface Patterns {
    String OPERATION = "[-+/*]";
    String SCALAR ="-?[0-9]+(\\.[0-9]+)?";
    String VECTOR ="\\{"+SCALAR+"?(,"+SCALAR+")*}";
    String MATRIX ="\\{"+VECTOR+"?(,"+SCALAR+")*}";
}
