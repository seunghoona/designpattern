package iterlator;

public class MenuItem {
    String name;
    String descritption;
    boolean vegetarian;
    double price;

    public MenuItem(String name, String descritption, boolean vegetarian, double price) {
        this.name = name;
        this.descritption = descritption;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescritption() {
        return descritption;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public double getPrice() {
        return price;
    }
}
