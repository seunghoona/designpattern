package factory;

public class VeggiePizza extends Pizza {

    public VeggiePizza() {
        name = "VeggiePizza";
        dough = "얇은";
        sauce = "토마토";
        toppings.add("야채");
    }

    @Override
    public void cut() {
        System.out.println("네모난형태로 자릅니다.");
    }
}
