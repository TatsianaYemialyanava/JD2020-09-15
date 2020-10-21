package by.it.dobrodey.jd02_01;


import java.util.ArrayList;
import java.util.List;


public class MarketNew {
    public static final int TIMEOPENMARKET = 120;
    static int count;
    static int second;

    public static void main(String[] args) {
        int buyerNumber = 0;
        System.out.println("Market opened");
        List<Buyer> buyerList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Buyer buyer = new Buyer(++buyerNumber);
            if (buyerNumber % 4 == 0) {
                buyer.setPriority(3);
            }
            buyer.start();
            buyerList.add(buyer);
        }
        for (second = 0; second < TIMEOPENMARKET; second++) {
            count = funchionCount(second);
            System.out.printf("In %d second in market %d people\n", second, Supervisor.buyersInMarket);
            if (Supervisor.buyersInMarket < count) {
                for (int i = 0; i < (count - Supervisor.buyersInMarket); i++) {
                    Buyer buyer = new Buyer(++buyerNumber);
                    if (buyerNumber % 4 == 0) {
                        buyer.setPriority(3);
                    }
                    ++buyerNumber;
                    buyer.start();
                    buyerList.add(buyer);
                }
                Helper.timeout(1000);
            } else Helper.timeout(1000);
        }

        for (Buyer buyerl : buyerList) {
            try {
                buyerl.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        FileReadAndWrite.printInFile(FileReadAndWrite.FILENAME, Choose.goodsBuyerMap);
        System.out.printf("In %d second in market %d people\n", second, Supervisor.buyersInMarket);
        System.out.println("Marked close");
    }

    private static int funchionCount(int second) {

        int secondNow = second % 60;
        if (secondNow <= 30) {
            count = secondNow + 10;
        } else {
            count = 40 + (30 - secondNow);
        }
        return count;
    }
}


