package state.first;

public class GuballMachineFirst {

    public State soldOutState;
    public State noQuarterState;
    public State hasQuarterState;
    public State soldState;
    public State winnerState;

    public State state = soldOutState;
    int count = 0;

    public GuballMachineFirst(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarteState(this);
        hasQuarterState = new HasQuarteState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuater() {
        state.ejectQuater();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispence();
    }
    public void setState(State state) {
        this.state = state;
    }

    public void releaseBall() {
        if(count != 0) {
            count = count - 1;
        }
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public int getCount() {
        return count;
    }

    public State getWinnerState() {
        return winnerState;
    }

}
