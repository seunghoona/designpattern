package template.hook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeWithHook extends  CaffeinBeverageWithHook{
    @Override
    protected void addCondiments() {
        System.out.println("필터로 커피를 우려내는 중");
    }

    @Override
    protected void brew() {
        System.out.println("우유와 설탕을 추가하는 중");
    }

    @Override
    public boolean customWantsCondiments() {
        String answer = getUserInput();
        if (answer.toLowerCase().startsWith("y")) {
            return true;
        }else {
            return false;
        }
    }

    private String getUserInput() {
        String answer = null;
        System.out.println("커피에 우유와 설탕을 넣어 드릴까요?");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = bufferedReader.readLine();
        }catch (IOException e) {
            System.out.println(e);
        }
        if (answer == null) {
            return "no";
        }
        return answer;
    }
}
