package orientation.adapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurkeyAdapterTest {

    @Test
    void duckTest(){
        MallardDuck duck = new MallardDuck();
        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        turkey.gobble();
        turkey.fly();
        System.out.println("----------------");
        testDuck(duck);
        System.out.println("----------------");
        testDuck(turkeyAdapter);
    }

    private void testDuck(Duck duck){
        duck.quack();
        duck.fly();
    }
}