package by.it.dobrodey.jd02_12;


import java.util.ArrayList;
import java.util.List;


public class Market {
    public static final int TIMEOPENMARKET = 2;
    private static int period;
    static int second;

    public static void main(String[] args) {
        int buyerNumber=0;
        System.out.println("Market opened");
        List<Buyer> buyerList = new ArrayList<>();
        for (second = 0; second < TIMEOPENMARKET; second++) {

            int count = Helper.getRandom(2);
            for (int i = 0; i < count; i++) {

                Buyer buyer = new Buyer(++buyerNumber);

                System.out.printf("In %d second in market %d people\n",second, Supervisor.buyersInMarket);

                if(buyerNumber%4==0){buyer.setPriority(3);}
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
        FileReadAndWrite.printInFile(FileReadAndWrite.FILENAME, Choose.goodsBuyerMap);
        System.out.println("Marked close");
    }
}
