package by.it.lapkovskiy.jd02_03;

import java.util.concurrent.LinkedBlockingDeque;


public class QueueBuyers {

    private static final Object monitor = new Object();

    private static LinkedBlockingDeque<Buyer> deque = new LinkedBlockingDeque<Buyer>(30);

    static void add(Buyer buyer) throws InterruptedException {
        synchronized (monitor) {
            deque.addLast(buyer);
        }
    }
    static void addPensioner(Buyer buyer) {
        synchronized (monitor) {
            deque.addFirst(buyer);
        }
    }

    static Buyer extract() throws InterruptedException {
        synchronized (monitor) {
            return deque.take();
        }
    }
    static int getBuyerSize(){
        synchronized (monitor){
            return deque.size();
        }
    }
    static void putInBegin(){

    }
}
