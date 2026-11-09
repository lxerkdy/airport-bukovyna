
package builder;

import java.util.List;

public class FlightPlan {

    // Обов'язкові параметри
    private final String route;
    private final String fuelCalculation;
    private final String weatherReport;

    // Необов'язкові параметри
    private final List<String> alternateAirports;
    private final String pilotMessages;
    private final String cargoData;
    private final String specialInstructions;

    FlightPlan(
            String route,
            String fuelCalculation,
            String weatherReport,
            List<String> alternateAirports,
            String pilotMessages,
            String cargoData,
            String specialInstructions
    ) {
        this.route = route;
        this.fuelCalculation = fuelCalculation;
        this.weatherReport = weatherReport;
        this.alternateAirports = List.copyOf(alternateAirports);
        this.pilotMessages = pilotMessages;
        this.cargoData = cargoData;
        this.specialInstructions = specialInstructions;
    }

    public String getRoute() {
        return route;
    }

    public String getFuelCalculation() {
        return fuelCalculation;
    }

    public String getWeatherReport() {
        return weatherReport;
    }

    public List<String> getAlternateAirports() {
        return alternateAirports;
    }

    public String getPilotMessages() {
        return pilotMessages;
    }

    public String getCargoData() {
        return cargoData;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    @Override
    public String toString() {
        return """
                Польотне завдання:
                  Маршрут: %s
                  Розрахунок палива: %s
                  Погодні умови: %s
                  Запасні аеродроми: %s
                  Повідомлення пілотам: %s
                  Дані про вантаж: %s
                  Спеціальні інструкції: %s
                """.formatted(
                route,
                fuelCalculation,
                weatherReport,
                alternateAirports.isEmpty() ? "Не вказано" : alternateAirports,
                optionalValue(pilotMessages),
                optionalValue(cargoData),
                optionalValue(specialInstructions)
        );
    }

    private String optionalValue(String value) {
        return value == null || value.isBlank()
                ? "Не вказано"
                : value;
    }
}
