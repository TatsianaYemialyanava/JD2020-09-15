package by.it.yemialyanava.jd02_01;

import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseBasket {

    Buyer(int number){
        this.setName("Buyer N" + number);
    }

    @Override
    public void run() {
        Supervisor.buyerInMarket++;
        enterToMarket();
        takeBasket();
        chooseGoods();

        goOut();
        Supervisor.buyerInMarket++;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started to choose goods");
        int timeout = Helper.getRandom(500, 2000);
        Helper.timeout(timeout);
        putGoodsToBasket();
        System.out.println(this + " finish to choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + " go out from Market");
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void takeBasket() {
        System.out.println(this + " take a basket");
    }

    @Override
    public void putGoodsToBasket() {
        Map<String, Double> goods = Good.getGoods();
        Object[] keys = goods.keySet().toArray();
        int goodsInBasket = Helper.getRandom (1, 4);
        String [] resultKeys = new String[goodsInBasket];

        for (int i = 0; i < goodsInBasket; i++) {
            int randomGoodIndex = Helper.getRandom(0, keys.length - 1);
            String key =(String) keys[randomGoodIndex];
            resultKeys[i] = key;
            Helper.timeout(500);
        }
        StringBuilder purches = new StringBuilder();
        for (String resultkey: resultKeys) {
            purches.append("\t").append(resultkey).append(" ").append(goods.get(resultkey)).append("\n");
        }
        System.out.println(this + " buy\n " + purches.toString());
    }
}
