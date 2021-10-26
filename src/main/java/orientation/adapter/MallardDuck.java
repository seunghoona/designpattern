package orientation.adapter;

public class MallardDuck implements Duck{

    @Override
    public void quack() {
        System.out.println("퀙");
    }

    @Override
    public void fly() {
        System.out.println("나는 날수 있어요");
    }
}
