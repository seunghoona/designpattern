package state.first;

import state.GuballMachine;

public class NoQuarteState implements State{
    GuballMachineFirst guballMachineFirst;

    public NoQuarteState(GuballMachineFirst guballMachineFirst) {
        this.guballMachineFirst = guballMachineFirst;
    }

    @Override
    public void insertQuarter() {
        System.out.println("동전을 넣으셨습니다.");
        guballMachineFirst.setState(guballMachineFirst.getHasQuarterState());
    }

    @Override
    // 동전을 넣지도 않은 상태에서 반환해달라고 하면 안되겠죠 ?
    public void ejectQuater() {
        System.out.println("동전을 넣어주세요");
    }

    @Override
    // 동전을 넣지 않은 상태에서 알맹이를 달라고 하면 안됨
    public void turnCrank() {
        System.out.println("동전을 넣어주세요");
    }

    @Override
    // 돈이 들어오기 전에는 알매이를 내줄 수 없습니다.
    public void dispence() {
        System.out.println("동전을 넣어주세요");
    }
}
