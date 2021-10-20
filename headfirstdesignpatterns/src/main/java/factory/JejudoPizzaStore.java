package factory;

public class JejudoPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        JejudoPizzaIngredientFactory jejudoPizzaIngredientFactory = new JejudoPizzaIngredientFactory();
        if (type.equals("clam")) {
            pizza = new ClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza(jejudoPizzaIngredientFactory);
        }
        return pizza;
    }
}
