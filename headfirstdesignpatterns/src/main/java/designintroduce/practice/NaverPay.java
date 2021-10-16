package designintroduce.practice;

public class NaverPay implements PayMentBehavior {
    @Override
    public void doPayment() {
        System.out.println("네이버 결제입니다.");
    }
}
