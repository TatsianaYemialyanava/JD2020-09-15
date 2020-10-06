package by.it.frolova.jd01_08;

public abstract class Var implements Operation {
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
