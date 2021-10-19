package factory;

import org.junit.jupiter.api.Test;

class PizzaStoreTest {
    @Test
    void simpleFactoryTest() {

        PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());
        pizzaStore.orderPizza("veggie");
        System.out.println("-------------------------");
        pizzaStore.orderPizza("clam");
    }
}