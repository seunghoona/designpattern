package template.hook;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

class CaffeinBeverageWithHookTest {

    @Test
    void TemplateHook() {

        System.setIn(new ByteArrayInputStream("yes".getBytes()));
        CaffeinBeverageWithHook caffeinBeverageWithHook = new CoffeeWithHook();
        caffeinBeverageWithHook.prepareRecipe();

        System.setIn(new ByteArrayInputStream("no".getBytes()));
        caffeinBeverageWithHook.prepareRecipe();
    }
}