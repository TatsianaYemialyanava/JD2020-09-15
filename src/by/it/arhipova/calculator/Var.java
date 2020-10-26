package by.it.arhipova.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

abstract class Var implements Operation {

    private static final Map<String,Var> vars = new HashMap<>();

    static void saveVar(String name, Var var){
        vars.put(name, var);
    }

    static Var createVar(String strVar) {
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else if (vars.containsKey(strVar))
        return vars.get(strVar);
        return null;
    }

    public static Var save(String name, Var value) {

        return value;

    }

    @Override
    public Var add(Var other) throws CalcExeption {

        throw new CalcExeption(String.format("Operation %s + %s impossible\n", this, other));
    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        throw new CalcExeption(String.format("Operation %s - %s impossible\n", this, other));

    }

    @Override
    public Var mul(Var other) throws CalcExeption {
        throw new CalcExeption(String.format("Operation %s * %s impossible\n", this, other));

    }

    @Override
    public Var div(Var other) throws CalcExeption {
        throw new CalcExeption(String.format("Operation %s / %s impossible\n", this, other));
    }

    @Override
    public String toString() {
        return "abstract Var";
    }
}
