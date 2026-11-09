package builder;

import java.util.List;

public interface FlightPlanBuilder {

    FlightPlanBuilder setRoute(String route);

    FlightPlanBuilder setFuelCalculation(String fuelCalculation);

    FlightPlanBuilder setWeatherReport(String weatherReport);

    FlightPlanBuilder setAlternateAirports(List<String> airports);

    FlightPlanBuilder setPilotMessages(String messages);

    FlightPlanBuilder setCargoData(String cargoData);

    FlightPlanBuilder setSpecialInstructions(String instructions);

    FlightPlan build();
}
