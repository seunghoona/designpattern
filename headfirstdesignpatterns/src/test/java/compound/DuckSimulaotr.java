package compound;

import org.junit.jupiter.api.Test;

class DuckSimulaotr {
    @Test
    void duck() {
        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable redheadDuck = new QuackCounter(new RedheadDuck());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable goose = new QuackCounter(new DuckGooseAdapter(new Goose()));

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(rubberDuck);
        simulate(duckCall);
        simulate(goose);

        System.out.println("QuackCOunter.getQuack() = " + QuackCounter.getQuack());

    }

    private void simulate(Quackable duck) {
        duck.quack();
    }
}