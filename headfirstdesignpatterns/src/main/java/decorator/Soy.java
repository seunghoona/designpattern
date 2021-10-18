package decorator;

public class Soy extends Beverage{

    public Soy(Size size) {
        super.description = "에스프레소";
        super.size = size;
    }

    public Soy() {
        super.description = "에스프레소";
    }

    @Override
    public double cost() {
        double sizeCost = Size.findSizeCost(size);

        return 3.4 + sizeCost;
    }
}
