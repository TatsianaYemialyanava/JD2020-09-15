package by.it.dobrodey.calc;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

abstract class Var implements Operation {

    private static Map<String,Var> varMap = new HashMap<>();
    public static Map <String,Var> getVarMap(){return varMap;}

    public static Var save(String name, Var value){
        varMap.put(name, value);
        return value;
    }


    static Var createVar(String strVar) {
        if (strVar.matches(Patterns.SCALAR)){
            return new Scalar(strVar);
        }
        else if (strVar.matches(Patterns.VECTOR)){
            return new Vector(strVar);
        }
        else if (strVar.matches(Patterns.MATRIX)){
            return new Matrix(strVar);
        }
        else {
            Var var = varMap.get(strVar);
            if (Objects.isNull(var)) {
                System.out.println("Unknow variable: " + strVar);
            }
            return var;
        }
    }


    public String toString() {
        return "abstract Var";
    }

    @Override
    public Var add(Var other) {
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
//       if(other.equals(new Scalar(0))){
//        System.out.println("not impossible div on 0");
//        return null;}
        System.out.printf("Operation %s / %s impossible\n", this, other);
        return null;
    }
}




