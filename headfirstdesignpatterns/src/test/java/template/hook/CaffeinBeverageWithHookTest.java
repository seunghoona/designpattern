package template.hook;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

class CaffeinBeverageWithHookTest {

    @Test
    void TemplateHook() {
        String yes = "yes";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(yes.getBytes())));
        CaffeinBeverageWithHook caffeinBeverageWithHook = new CoffeeWithHook();
        caffeinBeverageWithHook.prepareRecipe();
    }
}