package decorator;

public class HouseBlend extends Beverage{

    public HouseBlend(Size size) {
        description = "하우스블랜드";
        super.size = size;
    }
    public HouseBlend() {
        description = "하우스블랜드";
    }

    @Override
    public double cost() {
        return .89;
    }
}
