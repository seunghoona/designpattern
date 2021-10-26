package orientation;

public class Main {

    public static void main(String[] args) {
        Account account = new Account();
        int count = 100000;
        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                account.withDrawAll2();
            }
        }).start();

        new Thread(() -> {
            // 100000 회 금액 모두를 출금하는 흐름2
            for (int i = 0; i < count; ++i) {
                account.withDrawAll2();
            }
        }).start();

        new Thread(() -> {
            // 100000 회 금액 500원을 입금하는 흐름3
            for (int i = 0; i < count; ++i) {
                account.deposit_500();
            }
        }).start();
    }
}
