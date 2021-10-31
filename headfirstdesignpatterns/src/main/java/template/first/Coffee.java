package template.first;

public class Coffee extends CaffeinBeverage{
    @Override
    protected void addCondiments() {
        System.out.println("필터로 커피를 우려내느중");
    }

    @Override
    protected void brew() {
        System.out.println("설탕과 커피를 추가 하는 중");
    }
}
