package algorithm.javatest.designPattern.oberser;

import java.util.Observable;
import java.util.Observer;

public class Display implements Observer {

    private double temperature;

    public Display(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            temperature = weatherData.getTemperature();
            System.out.println(temperature);
        }
    }
}
