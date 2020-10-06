package by.it.frolova.jd01_09;

public abstract class Var implements Operation {

    static Var createVar(String strVar) {
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else
            System.out.println("Unknown variable: " + strVar);
        return null;
    }

    @Override
    public Var add(Var other) {
        //TODO create exception
        System.out.printf("Operation %s + %s impossible\n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        //TODO create exception
        System.out.printf("Operation %s - %s impossible\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        //TODO create exception
        System.out.printf("Operation %s * %s impossible\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        //TODO create exception
        System.out.printf("Operation %s / %s impossible\n", this, other);
        return null;
    }

    @Override
    public String toString() {
        return "from abstract";
    }
}
