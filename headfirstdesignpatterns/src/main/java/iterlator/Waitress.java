package iterlator;

import java.util.Iterator;

public class Waitress {
    PancakeHouseMenu pancakeHouseMenu;
    DinerMenu dinerMenu;

    public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    public void printMenu() {

        Iterator<MenuItem> iterator = dinerMenu.createIterator();
        Iterator<MenuItem> iterator1 = pancakeHouseMenu.createIterator();
        printMenu(iterator);
        printMenu(iterator1);
    }
    public void printMenu(Iterator<MenuItem> menuItemIterator) {
        while(menuItemIterator.hasNext()){
            MenuItem next = menuItemIterator.next();
            System.out.println("next = " + next.getName());
            System.out.println("next = " + next.getDescritption());
            System.out.println("next = " + next.getPrice());
        }
    }
}
