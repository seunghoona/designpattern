package state.first;

public class SoldState implements State{
    GuballMachineFirst guballMachineFirst;

    public SoldState(GuballMachineFirst guballMachineFirst) {
        this.guballMachineFirst = guballMachineFirst;
    }

    @Override
    public void insertQuarter() {
        System.out.println("잠깐만 기다려주세요 알맹이가 나가고 있습니다.");
    }

    @Override
    public void ejectQuater() {
        System.out.println("이미 알맹이를 뽑으셨습니다.");
    }

    @Override
    public void turnCrank() {
        System.out.println("손잡이는 한 번만 돌려주세요");
    }

    @Override
    public void dispence() {
        guballMachineFirst.releaseBall();
        if (guballMachineFirst.getCount() > 0 ) {
            guballMachineFirst.setState(guballMachineFirst.getNoQuarterState());
        } else {
            System.out.println("Oops");
            guballMachineFirst.setState(guballMachineFirst.soldOutState);
        }
    }
}
