package singleton;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class ChocolateBoiler {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private volatile static ChocolateBoiler chocolateBoiler;

    private boolean bean;
    private boolean boiled;
    private StringBuilder sb = new StringBuilder();
    private ChocolateBoiler() {
        this.bean = true;
        this.boiled = false;
    }

    public static ChocolateBoiler getInstance() {
        synchronized (Singleton.class) {
            if (chocolateBoiler == null) {
                chocolateBoiler = new ChocolateBoiler();
            }
        }
        return chocolateBoiler;
    }

    public void boil() {
        if (!isBinEmpty() && !isBoiled()) {
            logger.debug(Thread.currentThread().getName()+": boil");
            boiled = true;
        }
    }

    private boolean isBoiled() {
        return boiled;
    }

    // 보일러가 비어있는 경우에만 재료를 집어 넣습니다.
    public void fill() {
        if (isBinEmpty()) {
            logger.debug(Thread.currentThread().getName()+": fill");
            bean = false;
            boiled = false;
        }
    }

    private boolean isBinEmpty() {
        return bean;
    }

    public void drain() {

        if ((!isBinEmpty() && isBoiled())) {
            nextCreateChoco();
            logger.debug(Thread.currentThread().getName()+": drain");
        }
    }

    private void nextCreateChoco() {
        bean = true;
    }

    public String getSb() {
        return sb.toString();
    }
}
