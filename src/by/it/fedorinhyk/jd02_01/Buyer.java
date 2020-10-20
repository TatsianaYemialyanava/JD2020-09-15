package by.it.fedorinhyk.jd02_01;


class Buyer extends Thread implements IBuyer {
    Buyer (int number){
        this.setName("Покупатель №"+ number);
    }

    @Override
    public void run() {
        Supervisor.buyerInMarket++;
        enterToMarket();
        chooseGoods();
        goOut();
        Supervisor.buyerInMarket--;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+"начал выбирать товар");
        int timeout=Helper.getRandom(500,2000);
        Helper.timeout(timeout);
        System.out.println(this+"закончил выбирать товар");

    }

    @Override
    public void goOut() {
        System.out.println(this+" вышел из магазина");
    }

    @Override
    public String toString() {
        return getName();
    }
}