package by.it.frolova.jd02_02;

import java.util.Objects;

public class Cashier implements Runnable {

    private String name;

    public Cashier(int num) {
        this.name = "Cashier # " + num;
    }


    @Override
    public void run() {
        System.out.printf("%s is opened\n", this);
        while (!Supervisor.marketIsClosed()) {
            Buyer buyer = QueueToCashier.extract();
            if (Objects.nonNull(buyer)) {
                System.out.printf("%s started service for %s\n", this, buyer);
                int timeout = Helper.getRandom(2000, 5000);
                Helper.timeout(timeout);
                synchronized (buyer) {
                    buyer.setWaiting(false);
                    buyer.notify();
                }
            } else {
                Thread.yield();
            }
        }
        System.out.printf("%s closed\n", this);
    }

    @Override
    public String toString() {
        return name;
    }
}
