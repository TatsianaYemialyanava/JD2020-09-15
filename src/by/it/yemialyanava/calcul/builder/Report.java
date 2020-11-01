package by.it.yemialyanava.calcul.builder;

class Report {
    /** "Product" */

    private String head="";
    private String timeOfRun="";
    private String timeOfEnd="";
    private String informationPart="";

        //тут сеттеры дружественные, но это обычно это public методы
        void setDough(String dough)     { this.dough = dough; }
        void setSauce(String sauce)     { this.sauce = sauce; }
        void setTopping(String topping) { this.topping = topping; }


        @Override
        public String toString() {
            return "Pizza{" +
                    "dough='" + dough + '\'' +
                    ", sauce='" + sauce + '\'' +
                    ", topping='" + topping + '\'' +
                    '}';
        }
}
