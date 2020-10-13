package by.it.dobrodey.jd01_09;



abstract class Var implements Operation {

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




