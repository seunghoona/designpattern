package factory;

import org.junit.jupiter.api.Test;

class PizzaStoreTest {
    @Test
    void simpleFactoryTest() {

        PizzaStore pizzaStore = new JejudoPizzaStore();
        pizzaStore.orderPizza("veggie");
    }
}