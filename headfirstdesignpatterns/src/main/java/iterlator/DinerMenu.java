package iterlator;

import java.util.ArrayList;
import java.util.List;

public class DinerMenu {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("K&B 팬케이크 세트",
                "스크램블드에그",
                true,
                2.99);
    }

    private void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name,description,vegetarian,price);
        menuItems[numberOfItems] = menuItem;
        numberOfItems++;
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }
}
