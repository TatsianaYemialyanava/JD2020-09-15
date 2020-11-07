package by.it.yemialyanava.jd02_10;

class Person {
    private String name;
    private String lastName;
    private Passport passport;


    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }



    void setName(String name){
        this.name = name;
    }

    String getName(){
        return name;
    }

    void setLastName(String lastName){
        this.lastName = lastName;
    }

    String getLastName(){
        return lastName;
    }

}
