package by.it.yemialyanava.Calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

abstract class Var implements Operation {

    private  static Map<String, Var> varMap = new HashMap<>();

    public static HashMap<String, Var> getVarMap() {
        return (HashMap<String, Var>) varMap;
    }

    public static Var save (String name,Var value){
        varMap.put(name, value);
        return value;
    }
    /*public HashMap<String, Var> getVarMap()
    public double getValue() {
        return value;
    }*/

    static Var createVar (String strVar) throws CalcException{
        if (strVar.matches(Patterns.SCALAR)){
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)){
            return new Vector(strVar);
        }else if (strVar.matches(Patterns.MATRIX)){
            return new Matrix(strVar);
        } else{
            Var var = varMap.get(strVar);
            if (Objects.isNull(var)){
                throw new CalcException("Unknown variable: " + strVar);
            }
            return var;
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s + %s impossible\n", this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException(String.format("Operation %s - %s impossible\n", this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException(String.format("Operation %s * %s impossible\n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException(String.format("Operation %s / %s impossible\n", this, other));
    }

    @Override
    public String toString() {
        return "abstract Var";
    }
}
