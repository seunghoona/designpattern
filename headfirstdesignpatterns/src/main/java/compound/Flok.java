package compound;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flok implements Quackable {

    List<Quackable> quackables = new ArrayList<>();

    public void add(Quackable quacker) {
        quackables.add(quacker);
    }

    @Override
    public void quack() {
        for (Quackable quackable : quackables) {
            quackable.quack();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        for (Quackable duck : quackables) {
            duck.registerObserver(observer);
        }
    }

    @Override
    public void notifyObserver() {
    }
}
