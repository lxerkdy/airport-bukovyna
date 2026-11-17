package adapter;

import common.ConsoleLogger;

public class FlightControlCenter {

    private final WeatherProvider weatherProvider;

    public FlightControlCenter(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public void checkWeatherForTakeoff(String flightNumber) {
        ConsoleLogger.log("FlightControlCenter",
                "Перевірка погоди для рейсу " + flightNumber);

        double temperature = weatherProvider.getTemperatureCelsius();
        double windSpeed = weatherProvider.getWindSpeedMetersPerSecond();
        double visibility = weatherProvider.getVisibilityMeters();

        ConsoleLogger.log("FlightControlCenter",
                String.format(
                        "Метеодані: %.1f °C, %.2f м/с, %.1f м",
                        temperature, windSpeed, visibility
                ));

        if (windSpeed <= 15 && visibility >= 1000) {
            ConsoleLogger.log("FlightControlCenter",
                    "Рейс " + flightNumber + ": дозвіл на зліт надано");
        } else {
            ConsoleLogger.log("FlightControlCenter",
                    "Рейс " + flightNumber + ": зліт заборонено");
        }
    }
}
