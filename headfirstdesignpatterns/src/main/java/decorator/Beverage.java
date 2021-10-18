package decorator;

public abstract class Beverage {
    public enum Size {
        TALL, GRANDE, VENTI;

        public static double findSizeCost(Size size) {
            if(size == Size.TALL){
                return 1.4;
            }
            if(size == Size.GRANDE){
                return 2.4;
            }
            if(size == Size.VENTI){
                return 3.4;
            }
            throw new IllegalArgumentException();
        }
    };
    protected String description = "제목없음";
    protected Size size = Size.TALL;

    public String getDescription() {
        return description;
    }

    public abstract double cost();

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
