package observer;

import java.util.Observable;
import java.util.Observer;

public class CureentConditionDisplay implements Observer, DisplayElement {

    private final Observable observable;
    private float temperature;
    private float humidity;

    public CureentConditionDisplay(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "CureentConditionDisplay{" +
                "observable=" + observable +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }
}
