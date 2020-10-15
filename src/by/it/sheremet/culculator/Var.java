package by.it.sheremet.culculator;

abstract class Var implements Operation{

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
            System.out.println("Unknow variable: "+strVar);
            return null;
        }
    }


    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения "+this+"+"+other+"невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция сложения "+this+"+"+other+"невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция сложения "+this+"+"+other+"невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления "+this+"/"+other+"невозможна");
        return null;
    }
}
