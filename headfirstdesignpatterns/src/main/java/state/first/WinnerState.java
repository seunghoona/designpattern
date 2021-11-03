package state.first;

public class WinnerState implements State{
    GuballMachineFirst guballMachineFirst;

    public WinnerState(GuballMachineFirst guballMachineFirst) {
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
        System.out.println("축하드립니다 알맹이를 하나더 받을 수 있되었습니다.");
        if (guballMachineFirst.getCount() == 0) {
            guballMachineFirst.setState(guballMachineFirst.getSoldOutState());
        } else {
            guballMachineFirst.releaseBall();
            if (guballMachineFirst.getCount() > 0 ) {
                guballMachineFirst.setState(guballMachineFirst.getNoQuarterState());
            } else {
                System.out.println("더 이상 알맹이가 없습니다.");
                guballMachineFirst.setState(guballMachineFirst.getSoldOutState());
            }
        }
    }
}
