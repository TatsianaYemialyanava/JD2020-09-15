package by.it.dobrodey.jd02_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Experement {
    public static void main(String[] args) {

            Map<String,Double> goodsAndPrices = new HashMap<>();
            goodsAndPrices.put("FOOTWEAR",8.0);
            goodsAndPrices.put("GLOVES",13.0);
            goodsAndPrices.put("CLOTHES",1.0);
            goodsAndPrices.put("HEADDRESS",5.0);
            goodsAndPrices.put("DRINK",8.0);
            goodsAndPrices.put("TEA",13.0);
            goodsAndPrices.put("COFFEE",1.0);
            goodsAndPrices.put("EAT",5.0);
            goodsAndPrices.put("NEWSPAPER",8.0);
            goodsAndPrices.put("BOOK",13.0);
        final Set<String> strings = goodsAndPrices.keySet();

        for (String string : strings) {
            System.out.printf("%9s = %4.1f\n",string,goodsAndPrices.get(string));


        }

    }
}
