package by.it.sheremet.jd02_02;

import java.util.Objects;

class Cashier implements Runnable {

    private String name;



     Cashier(int number) {
       this.name = "\tCashier № " + number;

    }

    @Override
    public void run() {
        System.out.println(this+"open");

        while (!Supervisor.marketIsClose()){
            Buyer buyer = QueueBuyers.extract();
            if(Objects.nonNull(buyer)){
                System.out.printf("%s start service for %s\n", this, buyer);
                int t = Helper.getRandom(2000,5000);
                Helper.timeout(t);
                System.out.printf("%s finish service for %s\n", this, buyer);
                synchronized (buyer){
                    buyer.setWaiting(false);
                    buyer.notify();
                }
            }else {
                Thread.yield();
            }
        }

        System.out.println(this+"close");
    }
     @Override
     public String toString() {
         return name;
     }
}
