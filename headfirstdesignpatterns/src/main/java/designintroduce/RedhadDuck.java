package designintroduce;

public class RedhadDuck extends Duck {

    public RedhadDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void swim() {
        System.out.println("RedhadDuck swim");
    }

    @Override
    public void display() {
        System.out.println("RedhadDuck display");
    }
}
