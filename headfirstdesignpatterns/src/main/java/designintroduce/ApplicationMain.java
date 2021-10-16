package designintroduce;

public class ApplicationMain {
    public static void main(String[] args) {
        Duck redhadDuck = new RedhadDuck();
        redhadDuck.performQuack();
        redhadDuck.performFly();

        Duck mallardDuck = new MallardDuck();
        mallardDuck.performQuack();
        mallardDuck.performFly();

        Duck muteQuack = new DecoyDuck();
        muteQuack.performQuack();
        muteQuack.performFly();

        Duck modelsDuck = new ModelsDuck();
        modelsDuck.setFlyBehavior(new FlyNoWay());
        modelsDuck.setQuackBehavior(new MuteQuack());
        modelsDuck.performFly();
        modelsDuck.performQuack();

    }
}
