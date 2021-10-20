package factory;

public class VeggiePizza extends Pizza {
    PizzaIngredientFacotry pizzaIngredientFacotry;

    public VeggiePizza(PizzaIngredientFacotry pizzaIngredientFacotry) {
        this.pizzaIngredientFacotry = pizzaIngredientFacotry;
    }

    @Override
    void prepare() {
        dough = pizzaIngredientFacotry.createDough();
        sauce = pizzaIngredientFacotry.createSauce();
        clams = pizzaIngredientFacotry.createClam();
        veggies = pizzaIngredientFacotry.createVeggies();
    }

    @Override
    public void cut() {
        System.out.println("네모난형태로 자릅니다.");
    }
}
