package by.it.frolova.jd02_01;

import java.util.Iterator;


class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean pens = false;
    int timeout;
    private Basket basket;

    public Buyer(int number) {
        this.setName("Buyer № " + number);
        if (number % 4 == 0) {
            pens = true;
        }
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
        if (pens) {
            timeout = Helper.getRandom(7500, 30000);
        } else {
            timeout = Helper.getRandom(500, 2000);
        }
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
            int count = Helper.getRandom(1, 4);
            if (pens) {
                timeout = Helper.getRandom(7500, 30000);
            } else {
                timeout = Helper.getRandom(500, 2000);
            }
            Goods goods = new Goods();
            Iterator<Good> goodIterator = goods.getGoods().keySet().iterator();
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
        return getName() + "(" + pens + ")";
    }
}
