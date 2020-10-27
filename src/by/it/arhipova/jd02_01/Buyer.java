package by.it.arhipova.jd02_01;

public class Buyer extends Thread implements IBuyer {

    public Buyer(int number) {
        super("Buyer № " + number + " ");
    }

    @Override
    public void run() {
    enterToMarket();
    chooseGoods();
    goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "enter to the shop");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started to choose goods");
        int timeout = Helper.getRandom(500, 2000);
        Helper.sleep(timeout);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + "finished to choose goods");

    }

    @Override
    public void goOut() {
        System.out.println(this + "went out of the shop");

    }

    @Override
    public String toString() {
        return getName();
    }
}
