package decorator;

import org.junit.jupiter.api.Test;

class BeverageTest {

    @Test
    void beverageTest() {

        Beverage beverage = new Mocha(new Espresso());
        System.out.println(beverage.getDescription() + beverage.cost());

        Beverage whipCoffee = new Whip(new Mocha(new Espresso()));
        System.out.println(whipCoffee.getDescription() + whipCoffee.cost());

    }

}