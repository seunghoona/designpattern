package template;

public class Tea {
    void prepareRecipe() {
        boilWater();
        steepTeaBag();
        pourInCup();
        pourInCup();
    }

    private void boilWater() {
        System.out.println("물을 끓이는중");
    }

    private void steepTeaBag() {
        System.out.println("차를 우려내는중");
    }

    private void addLemon() {
        System.out.println("레몬을 추가하는중");
    }

    private void pourInCup() {
        System.out.println("컵에 따르는중");
    }
}
