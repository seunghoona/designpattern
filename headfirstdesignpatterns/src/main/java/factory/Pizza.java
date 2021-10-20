package factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected Cheese cheese;
    Veggies[] veggies;
    protected Pepperoni pepperoni;
    protected Clams clams;

    abstract void prepare();

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
