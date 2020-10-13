package by.it.yemialyanava.jd01_09;

public interface Patterns {
    String OPERATION = "[-+*/]";
    String SCALAR="-?[0-9]+(\\.[0-9]+)?";
    String VECTOR="\\{"+SCALAR+"?(,"+SCALAR+")*}";
    String MATRIX="\\{"+VECTOR+"?(,"+VECTOR+")*}";
}
