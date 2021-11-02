package composite;

import iterlator.first.Menu;

import java.util.Iterator;

public abstract class MenuComponet {
    public void  add(MenuComponet menuComponet) {
        throw new UnsupportedOperationException();
    }
    public void remove(MenuComponet menuComponet) {
        throw new UnsupportedOperationException();
    }
    public void getChild(int i) {
        throw new UnsupportedOperationException();
    }
    public String getName() {
        throw new UnsupportedOperationException();
    }
    public String getDescription() {
        throw new UnsupportedOperationException();
    }
    public double getPrice() {
        throw new UnsupportedOperationException();
    }
    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }
    public void print() {
        throw new UnsupportedOperationException();
    }
    public Iterator<MenuComponet> createIterator(){
        throw new UnsupportedOperationException();
    }
}
