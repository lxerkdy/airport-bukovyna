package builder;

import java.util.List;

public class FlightPlanDirector {

    public FlightPlan createRegularPassengerFlight(
            FlightPlanBuilder builder
    ) {
        return builder
                .setRoute("Чернівці - Київ")
                .setFuelCalculation("2500 кг")
                .setWeatherReport("Хмарно, вітер 5 м/с")
                .setAlternateAirports(
                        List.of("Львів", "Івано-Франківськ")
                )
                .setPilotMessages("Стандартний інструктаж екіпажу")
                .setCargoData("Пасажирський багаж")
                .setSpecialInstructions(
                        "Дотримуватися стандартного маршруту"
                )
                .build();
    }

    public FlightPlan createTrainingFlight(
            FlightPlanBuilder builder
    ) {
        return builder
                .setRoute("Чернівці - тренувальна зона - Чернівці")
                .setFuelCalculation("800 кг")
                .setWeatherReport("Ясно, вітер 2 м/с")
                .build();
    }
}
