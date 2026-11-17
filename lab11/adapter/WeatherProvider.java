package adapter;

public interface WeatherProvider {

    double getTemperatureCelsius();

    double getWindSpeedMetersPerSecond();

    double getVisibilityMeters();
}
