package by.it.dobrodey.jd02_01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class Market {
    static int second;
    public static void main(String[] args) {
        int buyerNumber=0;
        System.out.println("Market opened");
        List<Buyer> buyerList = new ArrayList<>();
        for (second = 0; second < 5; second++) {

            int count = Helper.getRandom(2);
            for (int i = 0; i < count; i++) {
                Buyer buyer = new Buyer(++buyerNumber);
                buyer.start();
                buyerList.add(buyer);
            }
            Helper.timeout(1000);

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
        System.out.println("Marked close");
    }
}
