package by.it.akhmelev.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

abstract class Var implements Operation {

    private static Map<String, Var> varMap = new HashMap<>();

    static Var createVar(String strVar) {
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else {
            Var var = varMap.get(strVar);
            if (Objects.isNull(var)) {
                System.out.println("Unknow variable: " + strVar);
            }
            return var;
        }
    }

    public static Var save(String name, Var value) {
        varMap.put(name, value);
        return value;

    }

    @Override
    public Var add(Var other) {
        //TODO create exception
        System.out.printf("Operation %s + %s impossible\n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Operation %s - %s impossible\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Operation %s * %s impossible\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Operation %s / %s impossible\n", this, other);
        return null;
    }

    @Override
    public String toString() {
        return "abstract Var";
    }
}
