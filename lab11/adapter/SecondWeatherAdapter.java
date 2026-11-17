
package adapter;

import common.ConsoleLogger;

public class SecondWeatherAdapter implements WeatherProvider {

    private final SecondWeatherService service;

    public SecondWeatherAdapter(SecondWeatherService service) {
        this.service = service;
    }

    @Override
    public double getTemperatureCelsius() {
        double kelvin = service.fetchTemperatureKelvin();
        double celsius = kelvin - 273.15;

        ConsoleLogger.log("SecondWeatherAdapter",
                kelvin + " K -> " + celsius + " °C");

        return celsius;
    }

    @Override
    public double getWindSpeedMetersPerSecond() {
        double kmh = service.fetchWindSpeedKmh();
        double metersPerSecond = kmh / 3.6;

        ConsoleLogger.log("SecondWeatherAdapter",
                kmh + " км/год -> " + metersPerSecond + " м/с");

        return metersPerSecond;
    }

    @Override
    public double getVisibilityMeters() {
        double feet = service.fetchVisibilityFeet();
        double meters = feet * 0.3048;

        ConsoleLogger.log("SecondWeatherAdapter",
                feet + " футів -> " + meters + " м");

        return meters;
    }
}
