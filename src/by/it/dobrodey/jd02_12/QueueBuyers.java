package by.it.dobrodey.jd02_12;

import java.util.Deque;
import java.util.LinkedList;

public class QueueBuyers {

    private static final Object monitor = new Object();

    private static Deque<Buyer> deque = new LinkedList<>();


    static int getSize(){
        synchronized (monitor){
            return deque.size();
        }
    }

    static void add(Buyer buyer) {
        synchronized (monitor) {
            deque.addLast(buyer);
        }
    }

    static Buyer extract() {
        synchronized (monitor) {
            return deque.pollFirst();
        }
    }
}
