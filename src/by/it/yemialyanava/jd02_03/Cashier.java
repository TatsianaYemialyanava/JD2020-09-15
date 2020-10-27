package by.it.yemialyanava.jd02_03;

import java.util.*;

public class Cashier implements Runnable {
    private String name;
    public static Object pause = new Object();

    private Queue<Bill> billsQueue = new LinkedList<Bill>();

    public Cashier(int number) {
        this.name = "Cashier № " + number;
    }

    @Override
    public void run() {
        System.out.printf("%s opened\n", this);
        while(!Supervisor.marketIsClosed()) {
            Buyer buyer;
            if(QueueBuyers.countBuyerInQueuePensioneer() !=0){
                buyer = QueueBuyers.extractPensioneer();
            } else {
                buyer = QueueBuyers.extract();
            }
            if (Objects.nonNull(buyer)) {
                System.out.printf("%s started service for %s\n", this, buyer);
                int t = Helper.getRandom(2000, 5000);
                Helper.timeout(t);
                Map<String, Double> buyersGoods = buyer.getMyGoods();
                double totalSumma = 0;
                for (Map.Entry<String, Double> element : buyersGoods.entrySet()) {
                    Double goodPrice = element.getValue();
                    totalSumma += goodPrice;
                }
                Bill bill = new Bill();
                bill.setGoods(buyersGoods);
                bill.setTotalCount(totalSumma);
                addToBillQueue(bill);
                System.out.println(this + "  serviced " +  buyer + "\n ");
                System.out.printf("%s finished service for %s\n", this, buyer);
                synchronized (buyer) {
                    buyer.setWaiting(false);
                    buyer.notify();
                }
            } else {
                synchronized (pause){
                    Supervisor.cashierStopWork();
                    try {
                        Cashier.pause.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Supervisor.cashierWorkNow();
            }
        }
        System.out.printf("%s closed\n", this);
    }

    public synchronized void addToBillQueue(Bill bill) {
        billsQueue.offer(bill);
    }
    public synchronized Bill getTopBillFromQueue() {
        return billsQueue.poll();
    }

    @Override
    public String toString() {
        return name;
    }
}
