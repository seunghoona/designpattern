package decorator;

import decorator.api.LowerCaseInputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

class BeverageTest {

    @Test
    void beverageTest() {

        Beverage beverage = new Mocha(new Espresso());
        System.out.println(beverage.getDescription() + beverage.cost());

        Beverage whipCoffee = new Whip(new Mocha(new Espresso()));
        System.out.println(whipCoffee.getDescription() + whipCoffee.cost());

    }

    @Test
    @DisplayName("IO 데코레이터를 추가해서 테스트해보자")
    void LowerCaseString() throws IOException {
        String alphabet = "ABCDEFG";
        InputStream bufferedInputStream = new LowerCaseInputStream(new ByteArrayInputStream(alphabet.getBytes()));
        int c = 0;
        char[] outByte = new char[alphabet.getBytes().length];
        int i=0;
        while ((c = bufferedInputStream.read()) > -1) {
            outByte[i] = (char) c;
            i++;
        }
        String s = Arrays.toString(outByte).replaceAll("[^a-z]","");
        Assertions.assertEquals("abcdefg",s);
    }
}