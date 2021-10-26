package orientation.adapter;

public class WildTurkey implements Turkey{

    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("나는 짧은 거리를 날아");
    }
}
