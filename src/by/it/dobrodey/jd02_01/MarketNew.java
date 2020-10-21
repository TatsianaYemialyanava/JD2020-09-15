package by.it.dobrodey.jd02_01;


import java.util.ArrayList;
import java.util.List;


public class MarketNew {
    public static final int TIMEOPENMARKET = 120;
    static int count;
    static int second;
    static int buyerNumber;
    static List<Buyer> buyerList = new ArrayList<>();

    public static void main(String[] args) {
        buyerNumber = 0;
        System.out.println("Market opened");


        getBuyer(10);
        for (second = 0; second < TIMEOPENMARKET; second++) {
            count = funchionCount(second);
            System.out.printf("In %d second in market %d people\n", second, Supervisor.buyersInMarket);
            if (Supervisor.buyersInMarket < count) {
                getBuyer(count - Supervisor.buyersInMarket);
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
    static void getBuyer(int Number) {

        for (int i = 0; i < Number; i++) {
            Buyer buyer = new Buyer(++buyerNumber);
            if (buyerNumber % 4 == 0) {
                buyer.setPriority(3);
            }
            buyer.start();
            buyerList.add(buyer);
        }
    }
}


