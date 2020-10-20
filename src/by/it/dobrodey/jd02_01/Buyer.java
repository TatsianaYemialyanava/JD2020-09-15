package by.it.dobrodey.jd02_01;

public class Buyer extends Thread implements IBuyer {

    Buyer(int number) {
        this.setName("Buyer № " + number);
    }



    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {

        System.out.println(this + " enter to market");}

    @Override
    public void chooseGoods() {
        Basket basket = new Basket(this.toString());
        basket.takeBasket();
        System.out.println(this + "                  started to choose goods");
//        int timer = Helper.getRandom(500,2000);
//        Helper.timeout(timer);

        try {
            basket.putGoodsToBasket();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(this + "                  finished to choose goods");
    }



    @Override
    public void goOut() {System.out.println(this + " go out market");}

    @Override
    public String toString() {
        return getName();
    }
}
