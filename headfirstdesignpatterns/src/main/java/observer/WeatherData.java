package observer;

public class WeatherData {
    public float getTemperature() {

        return 0f;
    }
    public float getHumidity() {

        return 0f;
    }
    public float getPressure() {

        return 0f;
    }

    /**
     * 기상 값이 갱신될 때마다 알려주기 위한 메소드
     * 현재조건, 기상통계, 기상예측
     */

    public void measurementsChanged() {
        float temp = getTemperature();
        float humidity = getHumidity();
        float pressure = getPressure();
        currentConditionDisplay.update(temp, humidity, pressure);
        statisticsDisplay.update(temp, humidity, pressure);
        forecastDisplay.update(temp, humidity, pressure);
    }
}
