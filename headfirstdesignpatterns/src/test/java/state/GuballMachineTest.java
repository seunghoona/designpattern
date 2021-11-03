package state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuballMachineTest {


    @Test
    void name() {
        GuballMachine guballMachine = new GuballMachine(5);
        System.out.println(guballMachine);
        System.out.println("================");

        guballMachine.inseruarter();
        guballMachine.turnCrank();
        System.out.println(guballMachine);
        System.out.println("================");

        guballMachine.inseruarter();
        guballMachine.ejectQuarter();
        guballMachine.turnCrank();

        System.out.println(guballMachine);
        System.out.println("================");
        guballMachine.inseruarter();
        guballMachine.turnCrank();
        guballMachine.inseruarter();
        guballMachine.turnCrank();
        guballMachine.ejectQuarter();

        System.out.println(guballMachine);
        System.out.println("================");
        guballMachine.inseruarter();
        guballMachine.inseruarter();
        guballMachine.turnCrank();
        guballMachine.inseruarter();
        guballMachine.turnCrank();
        guballMachine.inseruarter();
        guballMachine.turnCrank();

        System.out.println(guballMachine);
    }
}