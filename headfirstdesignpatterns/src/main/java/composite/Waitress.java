package composite;

import iterlator.MenuItem;
import iterlator.first.Menu;

import java.util.Iterator;

public class Waitress {
    MenuComponet menuComponet;

    public Waitress(MenuComponet menuComponet) {
        this.menuComponet = menuComponet;
    }

    public void printMenu() {
        menuComponet.print();
    }
}
