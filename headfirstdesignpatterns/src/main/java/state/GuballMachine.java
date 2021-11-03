package state;

public class GuballMachine {
    final static int SOLD_OUT = 0;
    final static int NO_QUARTER = 1;
    final static int HAS_QUARTER = 2;
    final static int SOLD = 3;
    private int count;
    private int state;


    public GuballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_QUARTER;
        }
    }


    public void inseruarter() {
        if (state == HAS_QUARTER) {
            System.out.println("동전은 한 개만 넣어주세요");
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("동전을 넣으셨습니다.");
        } else if (state == SOLD_OUT) {
            System.out.println("매진되었습니다, 다음기회에 이용해주세요");
        } else if (state == SOLD) {
            System.out.println("잠깐만 기다려주세요 알맹이가 나가고 있습니다.");
        }
    }
    // 동전을 반환 받으려고 하는 경우
    public void ejectQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("동전이 반환됩니다.");
            state = NO_QUARTER;
        } else if (state == NO_QUARTER) {
            System.out.println("동전을 넣어주세요");
        } else if (state == SOLD) {
            System.out.println("이미 알맹이를 뽑으셨습니다.");
        } else if (state == SOLD_OUT) {
            System.out.println("동전을 넣지 않으셨습니다, 동전이 반환되지 않습니다.");
        }
    }

    // 손잡이를 돌리는 경우
    public void turnCrank() {
        if (state == SOLD) {
            System.out.println("손잡이는 한 번만 돌려주세욘");
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("동전을 넣어주세요");
        } else if (state == SOLD_OUT) {
            System.out.println("매진 되었습니다.");
        } else if (state == HAS_QUARTER) {
            System.out.println("손잡이를 돌리셨습니다.");
            state = SOLD;
            dispense();
        }
    }

    public void dispense() {
        if(state == SOLD) {
            System.out.println("알맹이가 나가고 있습니다.");
            count = count - 1;
            if (count == 0 ) {
                System.out.println("더 이상 알맹이가 없습니다.");
            } else {
                state = NO_QUARTER;
            }
        } else if (state == NO_QUARTER) {
            System.out.println("동전을 넣어주세요");
        } else if (state == SOLD_OUT) {
            System.out.println("매진입니다.");
        } else if (state == HAS_QUARTER) {
            System.out.println("알맹이가 나갈 수 없습니다.");
        }
    }


    @Override
    public String toString() {
        return "GuballMachine{" +
                "count=" + count +
                ", state=" + state +
                '}';
    }
}
