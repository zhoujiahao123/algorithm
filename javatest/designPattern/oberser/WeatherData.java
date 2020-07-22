package algorithm.javatest.designPattern.oberser;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class WeatherData extends Observable {
    private double temperature;

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        alreadyChanged();
    }

    private void alreadyChanged() {
        setChanged();
        notifyObservers();
    }

    public double getTemperature() {
        return temperature;
    }
}
