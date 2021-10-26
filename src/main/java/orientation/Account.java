package orientation;

import java.util.Optional;

public class Account {
    private Integer money = 0;


    public void deposit_500() {
        money += 500;
    }

    public synchronized void withDrawAll() {
        int withDraw = money;

        if(money - withDraw >= 0){
            money -= withDraw;
        }
        if (money < 0) {
            throw new RuntimeException("[에러발생] 돈의 금액이 음수가 되었음 --> 돈의 현재 금액 :" + money);
        }
    }

    public void withDrawAll2() {
        int withDraw = money;
        money = Optional.of(money)
                .filter(number -> number - withDraw >= 0)
                .map(number -> number - withDraw)
                .orElse(money);
        if (money < 0) {
            throw new RuntimeException("[에러발생] 돈의 금액이 음수가 되었음");
        }
    }
}
