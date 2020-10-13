package by.it.yemialyanava.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

abstract class Var implements Operation {
    private  static Map<String, Var> varMap = new HashMap<>();




    public static Var save(String name,Var value){
        varMap.put(name, value);
        return value;
    }
    //public Map<String, Var> getVarMap() {
      //  return varMap;

    static Var createVar (String strVar){
        if (strVar.matches(Patterns.SCALAR)){
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)){
            return new Vector(strVar);
        }else if (strVar.matches(Patterns.MATRIX)){
            return new Matrix(strVar);
        } else{
            Var var = varMap.get(strVar);
            if (Objects.isNull(var)){
                System.out.println("Unknown variable: " + strVar);
            }
            return var;
        }
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения " + this + "+" + other + " невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания " + this + "+" + other + " невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения " + this + "+" + other + " невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления " + this + "+" + other + " невозможна");
        return null;
    }

    @Override
    public String toString() {
        return "Это класс Var";
    }
}
