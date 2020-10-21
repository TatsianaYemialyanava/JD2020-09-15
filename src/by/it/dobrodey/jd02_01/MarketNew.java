package by.it.dobrodey.jd02_01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MarketNew {
    public static final int TIMEOPENMARKET = 120;

    static int second;

    public static void main(String[] args) {
        int buyerNumber = 0;
        System.out.println("Market opened");
        List<Buyer> buyerList = new ArrayList<>();

        for (second = 0; second < TIMEOPENMARKET; second++) {


            int count;
            int secondNow = second % 60;
            if (secondNow < 30) {
                count = secondNow + 10;
            } else {
                count = 40 + (30 - secondNow);
            }

            if (Supervisor.buyersInMarket < count) {

                for (int i = 0; i < (count - Supervisor.buyersInMarket); i++) {
                    System.out.printf("In %d second in market %d people\n", second, Supervisor.buyersInMarket);
                    Buyer buyer = new Buyer(++buyerNumber);
                    if (buyerNumber % 4 == 0) {
                        buyer.setPriority(3);
                    }
                    buyer.start();
                    buyerList.add(buyer);
                }

                Helper.timeout(1000);
            } else Helper.timeout(1000);
        }

        for (Buyer buyer : buyerList) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try (PrintWriter writer = new PrintWriter(FileReadAndWrite.FILENAME)) {
            writer.println(Choose.goodsBuyerMap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("In %d second in market %d people\n", second, Supervisor.buyersInMarket);
        System.out.println("Marked close");
    }
}


