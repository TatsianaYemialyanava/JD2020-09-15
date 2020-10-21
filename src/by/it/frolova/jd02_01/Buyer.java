package by.it.frolova.jd02_01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseBasket {
    private final Map<Good, Double> goods;

    private Basket basket;

    public Buyer(int number) {
        this.setName("Buyer № " + number);
        goods = new HashMap<>();
        goods.put(new Good("bread"), 3.05);
        goods.put(new Good("milk"), 2.25);
        goods.put(new Good("salt"), 0.25);
        goods.put(new Good("cheese"), 10.25);
        goods.put(new Good("coffee"), 20.07);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started to choose");
        int timeout = Helper.getRandom(500, 2000);
        Helper.timeout(timeout);
        System.out.println(this + " finished to choose");

    }

    @Override
    public void goOut() {
        System.out.println(this + " went out of the market");

    }

    @Override
    public void takeBasket() {
        this.basket = new Basket();
        System.out.println(this + " took a basket");
    }

    @Override
    public void putGoodsToBasket() {
        if (this.basket != null) {
            int count = Helper.getRandom(1,4);
            int timeout = Helper.getRandom(500, 2000);
            Iterator<Good> goodIterator = goods.keySet().iterator();
            for (int i = 0; i < count; i++) {
                Good g = goodIterator.next();
                basket.add(g);
                System.out.println(this + " put " + g + " to the basket");
                Helper.timeout(timeout);
            }

        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
