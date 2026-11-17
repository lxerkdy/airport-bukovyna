package adapter;

import common.ConsoleLogger;

public class WeatherAdapter implements WeatherProvider {

    private final InternationalWeatherService service;

    public WeatherAdapter(InternationalWeatherService service) {
        this.service = service;
    }

    @Override
    public double getTemperatureCelsius() {
        double fahrenheit = service.readTemperatureFahrenheit();
        double celsius = (fahrenheit - 32) * 5 / 9;

        ConsoleLogger.log("WeatherAdapter",
                fahrenheit + " °F -> " + celsius + " °C");

        return celsius;
    }

    @Override
    public double getWindSpeedMetersPerSecond() {
        double knots = service.readWindSpeedKnots();
        double metersPerSecond = knots * 0.514444;

        ConsoleLogger.log("WeatherAdapter",
                knots + " вузлів -> " + metersPerSecond + " м/с");

        return metersPerSecond;
    }

    @Override
    public double getVisibilityMeters() {
        double miles = service.readVisibilityMiles();
        double meters = miles * 1609.344;

        ConsoleLogger.log("WeatherAdapter",
                miles + " миль -> " + meters + " м");

        return meters;
    }
}
