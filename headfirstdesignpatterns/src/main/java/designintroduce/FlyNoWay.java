package designintroduce;

public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("날수 없어요");
    }
}
