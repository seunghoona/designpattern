package decorator;

public class Espresso extends Beverage{

    public Espresso(Size size) {
        super.description = "에스프레소";
        super.size = size;
    }
    public Espresso() {
        super.description = "에스프레소";
    }

    @Override
    public double cost() {


        return 1.99;
    }
}
