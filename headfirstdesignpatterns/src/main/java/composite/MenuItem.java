package composite;

public class MenuItem extends MenuComponet{
    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
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
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void print() {
        System.out.println("getName() = " + getName());
        if(isVegetarian()) {
            System.out.println("(v)");
        }
        System.out.println("getPrice() = " + getPrice());
        System.out.println(getDescription());
    }
}
