package by.it.frolova.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {


    public static void main(String[] args) {

        System.out.println("Market is opened");
        List<Thread> threads = new ArrayList<>();
        int buyerNumber = 0;

        for (int i = 1; i < 3; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }
        while (Supervisor.marketIsOpen()){
            int count = Helper.getRandom(2);
            for (int i = 0; i < count && Supervisor.marketIsOpen(); i++) {
                Buyer buyer = new Buyer(++buyerNumber);
                buyer.start();
                threads.add(buyer);
            }
            Helper.timeout(1000);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Market is closed");
    }
}
