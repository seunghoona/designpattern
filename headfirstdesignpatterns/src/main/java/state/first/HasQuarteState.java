package state.first;

import java.util.Random;

public class HasQuarteState implements State{
    GuballMachineFirst guballMachineFirst;
    Random random = new Random(System.currentTimeMillis());

    public HasQuarteState(GuballMachineFirst guballMachineFirst) {
        this.guballMachineFirst = guballMachineFirst;
    }

    @Override
    public void insertQuarter() {
        System.out.println("동전을 한개만 넣어주세요");
    }

    @Override
    // 동전을 돌려주고 상태를 동전 없음으로 변경
    public void ejectQuater() {
        System.out.println("동전이 반환됩니다.");
        guballMachineFirst.setState(guballMachineFirst.getNoQuarterState());
    }

    @Override
    // 상태를 판매로 변경
    public void turnCrank() {
        System.out.println("손잡이를 돌리셨습니다.");
        int winner = random.nextInt(10);
        if ((winner == 0 ) && guballMachineFirst.getCount() > 1) {
            guballMachineFirst.setState(guballMachineFirst.getWinnerState());
        } else {
            guballMachineFirst.setState(guballMachineFirst.getSoldState());
        }

        guballMachineFirst.setState(guballMachineFirst.getSoldState());
    }

    @Override
    public void dispence() {
        System.out.println("알맹이가 나갈 수 없습니다.");
    }
}
