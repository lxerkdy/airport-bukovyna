package builder;

import java.util.ArrayList;
import java.util.List;

public class ConcreteFlightPlanBuilder implements FlightPlanBuilder {

    private String route;
    private String fuelCalculation;
    private String weatherReport;

    private List<String> alternateAirports = new ArrayList<>();
    private String pilotMessages;
    private String cargoData;
    private String specialInstructions;

    @Override
    public FlightPlanBuilder setRoute(String route) {
        this.route = route;
        return this;
    }

    @Override
    public FlightPlanBuilder setFuelCalculation(String fuelCalculation) {
        this.fuelCalculation = fuelCalculation;
        return this;
    }

    @Override
    public FlightPlanBuilder setWeatherReport(String weatherReport) {
        this.weatherReport = weatherReport;
        return this;
    }

    @Override
    public FlightPlanBuilder setAlternateAirports(List<String> airports) {
        this.alternateAirports = new ArrayList<>(airports);
        return this;
    }

    @Override
    public FlightPlanBuilder setPilotMessages(String messages) {
        this.pilotMessages = messages;
        return this;
    }

    @Override
    public FlightPlanBuilder setCargoData(String cargoData) {
        this.cargoData = cargoData;
        return this;
    }

    @Override
    public FlightPlanBuilder setSpecialInstructions(String instructions) {
        this.specialInstructions = instructions;
        return this;
    }

    @Override
    public FlightPlan build() {

        if (route == null || route.isBlank()) {
            throw new IllegalStateException(
                    "Неможливо сформувати польотне завдання: не задано маршрут"
            );
        }

        if (fuelCalculation == null || fuelCalculation.isBlank()) {
            throw new IllegalStateException(
                    "Неможливо сформувати польотне завдання: не задано розрахунок палива"
            );
        }

        if (weatherReport == null || weatherReport.isBlank()) {
            throw new IllegalStateException(
                    "Неможливо сформувати польотне завдання: не задано погодний звіт"
            );
        }

        return new FlightPlan(
                route,
                fuelCalculation,
                weatherReport,
                alternateAirports,
                pilotMessages,
                cargoData,
                specialInstructions
        );
    }

    public void reset() {
        route = null;
        fuelCalculation = null;
        weatherReport = null;
        alternateAirports.clear();
        pilotMessages = null;
        cargoData = null;
        specialInstructions = null;
    }
}
