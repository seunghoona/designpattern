package singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChocolateBoilerTest {

    @Test
    @DisplayName("일반사용")
    void createChoco() {


        ChocolateBoiler instance = ChocolateBoiler.getInstance();
        instance.fill();
        instance.boil();
        instance.drain();
        instance.fill();
        instance.boil();
        instance.drain();
    }


    @Test
    @DisplayName("스레드를 이용한 방법")
    void createChocoThread() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                ChocolateBoiler instance = ChocolateBoiler.getInstance();
                instance.fill();
                instance.boil();
                instance.drain();
            }).start();
        }
    }
}