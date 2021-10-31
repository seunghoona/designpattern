package template.first;

public class Tea extends CaffeinBeverage{
    @Override
    protected void addCondiments() {
        System.out.println("레몬을 추가하는중");
    }

    @Override
    protected void brew() {
        System.out.println("차를 우려내는 중");
    }
}
