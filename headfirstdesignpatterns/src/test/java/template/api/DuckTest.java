package template.api;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DuckTest {


    @Test
    void duckSort() {
        Duck[] ducks = {
                new Duck("승후", 1),
                new Duck("민호", 2),
                new Duck("지호", 6),
                new Duck("기호", 4),
                new Duck("니호", 5),
                new Duck("그오", 9)
        };
        Arrays.sort(ducks);

        Arrays.stream(ducks).forEach(s -> {
            System.out.println(s.toString());
        }
        );
    }
}