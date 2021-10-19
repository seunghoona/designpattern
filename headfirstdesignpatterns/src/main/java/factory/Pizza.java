package factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    protected String name;
    protected String dough;
    protected String sauce;
    List<String> toppings = new ArrayList<>();

    public void prepare() {
        System.out.println("preparing = " + name);
        System.out.println("도우굽기");
        System.out.println("소스");
        System.out.println("토핑올리기");
        toppings.stream().forEach(System.out::println);
    }

    public void bake() {
        System.out.println("25분동안 굽기");
    }

    public void cut() {
        System.out.println("피자 자르기");
    }

    public void box() {
        System.out.println("피자 박스에 담기");
    }
}
