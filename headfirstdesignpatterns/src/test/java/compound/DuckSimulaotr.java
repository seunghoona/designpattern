package compound;

import org.junit.jupiter.api.Test;

class DuckSimulaotr {
    @Test
    void duck() {

        AbstractDuckFactory duckFactory = new CountingDuckFactory();


        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedHeadDuck();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable duckCall = duckFactory.createDuckCall();
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