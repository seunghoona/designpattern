package composite;

import iterlator.MenuItem;

import java.util.Iterator;

public class Waitress {
    MenuComponet menuComponet;

    public Waitress(MenuComponet menuComponet) {
        this.menuComponet = menuComponet;
    }

    public void printMenu() {
        menuComponet.print();
    }

    public void printVegetarianMenu() {
        Iterator<MenuComponet> iterator = menuComponet.createIterator();
        while (iterator.hasNext()) {
            MenuComponet menuComponent = iterator.next();
            try {
                if (menuComponent.isVegetarian()) {
                    menuComponent.print();
                }
            } catch (UnsupportedOperationException e) {}
        }
    }
}
