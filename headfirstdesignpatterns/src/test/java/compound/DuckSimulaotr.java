package compound;

import org.junit.jupiter.api.Test;

class DuckSimulaotr {
    @Test
    void duck() {
        Quackable mallardDuck = new MallardDuck();
        Quackable redheadDuck = new RedheadDuck();
        Quackable rubberDuck = new RubberDuck();
        Quackable duckCall = new DuckCall();

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(rubberDuck);
        simulate(duckCall);
    }

    private void simulate(Quackable duck) {
        duck.quack();
    }
}