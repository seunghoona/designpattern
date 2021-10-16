package designintroduce.practice;

public abstract class Product {

    private PayMentBehavior payMentBehavior;

    public void setPayMentBehavior(PayMentBehavior payMentBehavior) {
        this.payMentBehavior = payMentBehavior;
    }

    public void doPayment() {
        payMentBehavior.doPayment();
    }

    protected abstract void name();
    protected abstract void description();
}
