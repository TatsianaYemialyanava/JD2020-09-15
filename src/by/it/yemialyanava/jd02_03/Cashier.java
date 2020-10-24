package by.it.yemialyanava.jd02_03;

import java.util.Objects;

public class Cashier implements Runnable {
    private String name;

    public Cashier(int number){
        this.name = "\tCashier № " + number;
        Supervisor.addCashier();
    }

    @Override
    public void run() {
        System.out.printf("%s opened\n", this);
        double commonSummaAllBuyers = 0;
        while (!Supervisor.marketIsClosed() && (QueueBuyers.countBuyerInQueue() != 0 ||
                                                    QueueBuyers.countBuyerInQueuePensioneer() !=0)){
            Buyer buyer = null; ///?????
            if(QueueBuyers.countBuyerInQueuePensioneer() !=0){
                buyer = QueueBuyers.extractPensioneer();
            } else {
                buyer = QueueBuyers.extract();
            }

            if(Objects.nonNull(buyer)){
            System.out.printf("%s started service for %s\n", this, buyer);
                int t = Helper.getRandom(2000, 5000);
                Helper.timeout(t);
                System.out.printf("%s finished service for %s\n", this, buyer);
                //commonSummaAllBuyers = commonSummaAllBuyers;
                synchronized (buyer){
                    buyer.setWaiting(false);
                    buyer.notify();
                }
            }else {
                Thread.yield();
            }
        }

        System.out.printf("%s closed\n", this);
        Supervisor.cashierStopWork();
    }

    @Override
    public String toString() {
        return name;
    }
}
