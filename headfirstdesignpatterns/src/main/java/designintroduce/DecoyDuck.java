package designintroduce;

public class DecoyDuck extends Duck{

    public DecoyDuck() {
        quackBehavior = new MuteQuack();
        flyBehavior = new FlyNoWay();
    }

    @Override
    public void swim() {

    }

    @Override
    public void display() {
        System.out.println("Decoy display");
    }
}
