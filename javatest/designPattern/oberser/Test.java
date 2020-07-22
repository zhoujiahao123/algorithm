package algorithm.javatest.designPattern.oberser;

public class Test {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        new Display(weatherData);
        weatherData.setTemperature(10);
    }
}
