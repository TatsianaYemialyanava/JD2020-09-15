package by.it.hutnik.jd02_01;

import java.util.HashMap;
import java.util.Map;

class Buyer extends Thread implements IBuyer {

    public Buyer(int number) {
        super("Buyer №" + number);
    }

    @Override
    public void run() {
        enterToMarket(); //вошел в магазин (мгновенно)
        chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
        goOut(); //отправился на выход(мгновенно)
//        takeBasket(); //взял корзину
//        putGoodsToBasket(); //положил выбранный товар в корзину
        Dispatcher.BUYERS_IN_SHOP--;
    }

    @Override
    public void enterToMarket() {
        System.out.printf("%s enter to market", this);
    }

    @Override
    public void chooseGoods() {
        System.out.printf("%s started to choose\n", this);
        int timeout = Helper.getRandom(500, 2000);
        Thread.yield();
        Helper.mySleep(timeout);
        System.out.printf("%s finished to choose\n", this);
    }

    @Override
    public void goOut() {
        System.out.printf("%s leaved market\n", this);

    }

    @Override
    public String toString() {
        return this.getName();
    }



//    @Override
//    public void takeBasket() {
//        System.out.printf("%s take bascet\n", this);
//    }
//
//    @Override
//    public void putGoodsToBasket(){
//        int tovary = Helper.getRandom(0, 4);
//        int count = 0;
//        Map<String, Integer> perechen = new HashMap<>();
//        perechen.put("chleb", 3);
//        perechen.put("moloko", 2);
//        perechen.put("syr", 7);
//        perechen.put("tvorog", 5);
//        for(Map.Entry<String, Integer>entry: perechen.entrySet()){
//            if(count == tovary)
//                break;
//            System.out.printf("%s put % in the bascet\n", this, entry.getKey());
//            count++;
//        }
//        Helper.mySleep(Helper.getRandom(500, 2000));
//    }

}