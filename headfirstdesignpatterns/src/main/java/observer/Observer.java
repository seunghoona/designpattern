package observer;

/**
 *  Observer 인터페이스는 update 메소드를 구현해야합니다.
 *  옵저버한테 측정한 값들을 전달합니다.
 */
public interface Observer {
    void update(float temp, float humidity, float pressure);
}
