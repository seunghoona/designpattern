package iterlator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PancakeHouseMenuTest {


    @Test
    void pancakeHouseMenuAndBreakfastItem() {

        DinerMenu dinerMenu = new DinerMenu();
        MenuItem[] menuItems = dinerMenu.getMenuItems();

        for (int i = 0; i < menuItems.length; i++) {
            MenuItem menuItem = menuItems[i];
            System.out.println("menuItem.getName() = " + menuItem.getName());
            System.out.println("menuItem.getDescritption() = " + menuItem.getDescritption());
            System.out.println("menuItem = " + menuItem.getPrice());
        }

        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        List<MenuItem> menuItems1 = pancakeHouseMenu.getMenuItems();
        for (int i = 0; i < menuItems1.size(); i++) {
            System.out.println("menuItem.getName() = " + menuItems1.get(i).getName());
            System.out.println("menuItem.getDescritption() = " + menuItems1.get(i).getDescritption());
            System.out.println("menuItem = " + menuItems1.get(i).getPrice());
        }
    }
}