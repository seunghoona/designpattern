package designintroduce.practice;

public class GoodProduct extends Product{

    @Override
    protected void name() {
        System.out.println("좋은상품입니다.");
    }

    @Override
    protected void description() {
        System.out.println("만65세 이상 상품입니다.");
    }
}
