package template;

public class Coffe {
    void prepareRecipe() {
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
    }
    private void boilWater() {
        System.out.println("물을 끓이는중");
    }

    private void brewCoffeeGrinds() {
        System.out.println("필터를 통해 커피를 우려내는중");
    }

    private void pourInCup() {
        System.out.println("컵에 따르는중");
    }

    private void addSugarAndMilk() {
        System.out.println("설탕과 우유를 추가하는 중");
    }

}
