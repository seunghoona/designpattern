package template.hook;

public abstract class CaffeinBeverageWithHook {
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        // 하위 클래스에 의해 실행 여부가 결정됩니다.
        if (customWantsCondiments()) {
            addCondiments();
        }
    }
    //필요에 따라 오버라이드 할 수 있는 메소드
    public boolean customWantsCondiments() {
        return true;
    }

    private void boilWater() {
        System.out.println("물을 끓이는 중");
    }

    private void pourInCup() {
        System.out.println("컵에 따르는 중");
    }

    protected abstract void addCondiments();

    protected abstract void brew();
}
