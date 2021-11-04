package compound;

import designintroduce.Quack;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;
import java.util.Queue;

class DuckSimulaotr {
    @Test
    void duck() {

        AbstractDuckFactory duckFactory = new CountingDuckFactory();


        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedHeadDuck();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable goose = new QuackCounter(new DuckGooseAdapter(new Goose()));

        Flok flokOfDucks = new Flok();
        flokOfDucks.add(mallardDuck);
        flokOfDucks.add(duckCall);
        flokOfDucks.add(rubberDuck);
        flokOfDucks.add(redheadDuck);
        flokOfDucks.add(goose);

        flokOfDucks.registerObserver(new Quackologist());
        simulate(flokOfDucks);

        System.out.println("QuackCOunter.getQuack() = " + QuackCounter.getQuack());

    }

    private void simulate(Quackable duck) {
        duck.quack();
    }
}