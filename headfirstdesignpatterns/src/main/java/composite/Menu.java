package composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponet{
    private List<MenuComponet> menuComponetList;
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
        menuComponetList = new ArrayList<>();
    }

    @Override
    public void add(MenuComponet menuComponet) {
        menuComponetList.add(menuComponet);
    }

    @Override
    public void remove(MenuComponet menuComponet) {
        menuComponetList.remove(menuComponet);
    }

    @Override
    public void getChild(int i) {
        menuComponetList.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void print() {
        System.out.println(getName());
        System.out.println(getDescription());
        for (MenuComponet menuComponet : menuComponetList) {
            menuComponet.print();
        }
    }
}
