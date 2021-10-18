package decorator;

public abstract class CondimentDecorator extends Beverage{
    public Beverage beverage;
    /**
     *  모든 데코레이터를 구현하는 곳에서 {@link #getDescription() }을 구현하게 만들 계획입니다.
     * @return
     */
    public abstract String getDescription();

    public Size getSize() {
        return beverage.getSize();
    }

}
