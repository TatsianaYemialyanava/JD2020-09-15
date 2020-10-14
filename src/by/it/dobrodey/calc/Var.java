package by.it.dobrodey.calc;


import by.it.akhmelev.calculator.CalcException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

abstract class Var implements Operation {

    private static Map<String, Var> varMap = new HashMap<>();

    public static Map<String, Var> getVarMap() {
        return varMap;
    }

    public static Var save(String name, Var value) {
        varMap.put(name, value);
        return value;
    }


    static Var createVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else {
            Var var = varMap.get(strVar);
            if (Objects.isNull(var)) {
                throw new CalcException("Unknow variable: " + strVar);
            }
            return var;
        }
    }


    public String toString() {
        return "abstract Var";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s + %s impossible\n", this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s - %s impossible\n", this, other));

    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s * %s impossible\n", this, other));

    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s / %s impossible\n", this, other));
            }
}




