package by.it.kolesnikov.jd02_01;

class Buyer extends Thread implements IBuyer, IUseBasket {
    public static final Object ob = new Object();

    public Buyer(int number){
        this.setName("Buyer №"+number);
    }

    @Override
    public void run() {
            enterToMarket();
            takeBasket();
            choseGoods();
            putGoodsToBasket();
            goOut();
    }

    @Override
    public void takeBasket(){

        System.out.println(this+" took basket");
    }

    @Override
    public void putGoodsToBasket(){
        System.out.print(this+" put next goods into the basket: ");
        Basket.basket();
    }

    @Override
    public String toString() {

        return getName();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" entered to Market");
    }

    @Override
    public void choseGoods() {
        System.out.println(this+" started to choose goods");
        int timeout=Helper.getRandom(100, 200);
        Helper.timeOut(timeout);
        System.out.println(this+" finished to choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this+" went out of Market");
    }

}
