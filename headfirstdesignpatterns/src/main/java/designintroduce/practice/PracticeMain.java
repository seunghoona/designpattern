package designintroduce.practice;

public class PracticeMain {
    public static void main(String[] args) {
        Product product = new GoodProduct();
        product.setPayMentBehavior(new NaverPay());
        product.doPayment();
    }
}
