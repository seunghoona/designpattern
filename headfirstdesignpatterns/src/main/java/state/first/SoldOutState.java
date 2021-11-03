package state.first;

public class SoldOutState implements State{
    GuballMachineFirst guballMachineFirst;

    public SoldOutState(GuballMachineFirst guballMachineFirst) {
        this.guballMachineFirst = guballMachineFirst;
    }
    @Override
    public void insertQuarter() {
        System.out.println("매진되었습니다.");
    }

    @Override
    public void ejectQuater() {
        System.out.println("매진되었습니다. 동전을 넣지 않으셨기에 반환되지 않습니다.");
    }

    @Override
    public void turnCrank() {
        System.out.println("매진되었습니다.");
    }

    @Override
    public void dispence() {
        System.out.println("매진입니다.");
    }
}
