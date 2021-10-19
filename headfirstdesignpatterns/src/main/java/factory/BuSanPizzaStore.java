package factory;

public class BuSanPizzaStore extends PizzaStore{
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("apple")) {
            pizza = new ApplePizza();
        }else if (type.equals("grape")) {
            pizza = new GrapePizza();
        }
        return pizza;
    }
}
