package by.it.dobrodey.jd02_12;

class Supervisor {

    private Supervisor() {
    }

    private static volatile int buyersEnterToMarket = 0;
    private static volatile int buyersLeavedMarket = 0;

    static synchronized int getBuyer(){
        return buyersEnterToMarket-buyersLeavedMarket;
    }
    static  int getBuyerEnter(){
        return buyersEnterToMarket;
    }
    static  int getBuyerLeaved(){
        return buyersLeavedMarket;
    }

    private static final int buyerTotal = 10;//0;

    static synchronized void addBuyer() {
        buyersEnterToMarket++;
    }

    static void leaveBuyer() {
        synchronized (Supervisor.class) {
            buyersLeavedMarket++;
        }
    }

    static boolean marketIsOpened() {
        return buyersEnterToMarket != buyerTotal;
    }

    static boolean marketIsClosed() {
        return buyersLeavedMarket == buyerTotal;
    }


}

