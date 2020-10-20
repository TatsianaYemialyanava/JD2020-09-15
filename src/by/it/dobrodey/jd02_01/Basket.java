package by.it.dobrodey.jd02_01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Basket extends Thread implements IUseBasket {



    Basket(String number) {
        this.setName(number);
                     }
    //public Buyer value;value.getNumber()+value.getNumber()+


    @Override
    public void takeBasket() {
        Buyer buyer = null; ;
        System.out.println(this+"          " + "take basket");
    }

    @Override
    public void putGoodsToBasket() throws InterruptedException {

        int numberOfGoods = Helper.getRandom(1,4);
        HashMap <String,Double> goodsBuyer = new HashMap<>();
        Set<Map.Entry<String, Double>> entries = Choose.getMap().entrySet();
        Iterator<Map.Entry<String, Double>> iterator = entries.iterator();
        for (int i = 0; i < numberOfGoods; i++) {
            Map.Entry<String, Double> next = iterator.next();
            goodsBuyer.put(next.getKey(),next.getValue());
            System.out.println(this+"                                put goods to basket "
                                            +next.getKey()
                                            +" cost "
                                            +next.getValue());
            Helper.timeout(Helper.getRandom(500,2000));

        }
        //printer on consol all goods
        String basket = goodsBuyer.toString().replace("{","").
                replace("}","").replace("="," cost ");
        System.out.println(this+"                                   ALL goods to basket "+basket);
        Choose.goodsBuyerMap.put(this,goodsBuyer);



    }

    @Override
    public String toString() {
        return getName();
    }
}

