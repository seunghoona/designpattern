package observer;

import org.junit.jupiter.api.Test;

class WeatherDataTest {

    @Test
    void WeatherStationTest() {
        WeatherData weatherData = new WeatherData();
        CureentConditionDisplay cureentConditionDisplay = new CureentConditionDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }

}