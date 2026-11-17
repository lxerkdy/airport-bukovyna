
package adapter;

import common.ConsoleLogger;

public class SecondWeatherService {

    public double fetchTemperatureKelvin() {
        double temperature = 293.15;

        ConsoleLogger.log("SecondWeatherService",
                "Температура: " + temperature + " K");

        return temperature;
    }

    public double fetchWindSpeedKmh() {
        double windSpeed = 36.0;

        ConsoleLogger.log("SecondWeatherService",
                "Швидкість вітру: " + windSpeed + " км/год");

        return windSpeed;
    }

    public double fetchVisibilityFeet() {
        double visibility = 6561.68;

        ConsoleLogger.log("SecondWeatherService",
                "Видимість: " + visibility + " футів");

        return visibility;
    }
}
