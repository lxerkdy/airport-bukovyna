package adapter;

import common.ConsoleLogger;

public class InternationalWeatherService {

    public double readTemperatureFahrenheit() {
        double temperature = 68.0;

        ConsoleLogger.log("InternationalWeatherService",
                "Температура: " + temperature + " °F");

        return temperature;
    }

    public double readWindSpeedKnots() {
        double windSpeed = 10.0;

        ConsoleLogger.log("InternationalWeatherService",
                "Швидкість вітру: " + windSpeed + " вузлів");

        return windSpeed;
    }

    public double readVisibilityMiles() {
        double visibility = 6.0;

        ConsoleLogger.log("InternationalWeatherService",
                "Видимість: " + visibility + " миль");

        return visibility;
    }
}
