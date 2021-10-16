package designintroduce;

public class MallardDuck extends Duck{

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void swim() {
        System.out.println("MallardDuck swim");
    }

    @Override
    public void display() {
        System.out.println("MallardDuck swim");
    }
}
