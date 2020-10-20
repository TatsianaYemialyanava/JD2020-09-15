package by.it.dobrodey.jd02_01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Experement {
    public static void main(String[] args) {
        Map<String,Double> goodsAndPrices = new HashMap<>();
        goodsAndPrices.put("footwear",8.0);
        goodsAndPrices.put("gloves",13.0);
        goodsAndPrices.put("clothes",1.0);
        goodsAndPrices.put("headdress",5.0);
        System.out.println(goodsAndPrices);
        int numberOfGoods = Helper.getRandom(4);
        HashMap<String,Double> goodsBuyer = new HashMap<>();
        final Set<Map.Entry<String, Double>> entries = goodsAndPrices.entrySet();
        final Iterator<Map.Entry<String, Double>> iterator = entries.iterator();
        for (int i = 0; i < 3; i++) {
            final Map.Entry<String, Double> next = iterator.next();
            System.out.println(next.getKey()+" "+next.getValue());

        }


        System.out.println(goodsAndPrices.get("footwear"));


}}
