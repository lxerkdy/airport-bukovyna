
import builder.*;
import common.ConsoleLogger;

public class Main {

    public static void main(String[] args) {
        runBuilderScenario();
    }

    public static void runBuilderScenario() {

        FlightPlanDirector director = new FlightPlanDirector();

        // 1. Регулярний пасажирський рейс PS-101
        ConsoleLogger.log("Main", "Створення регулярного рейсу PS-101");

        try {
            FlightPlanBuilder builder = new ConcreteFlightPlanBuilder();

            FlightPlan plan = director.createRegularPassengerFlight(builder);

            ConsoleLogger.log("Builder", "Польотне завдання PS-101 створено");

            System.out.println(plan);

        } catch (IllegalStateException e) {
            ConsoleLogger.log("Builder", e.getMessage());
        }

        // 2. Навчальний політ
        ConsoleLogger.log("Main", "Створення навчального польоту");

        try {
            FlightPlanBuilder builder = new ConcreteFlightPlanBuilder();

            FlightPlan plan = director.createTrainingFlight(builder);

            ConsoleLogger.log("Builder", "Навчальне польотне завдання створено");

            System.out.println(plan);

        } catch (IllegalStateException e) {
            ConsoleLogger.log("Builder", e.getMessage());
        }

        // 3. Спроба створити завдання без розрахунку палива
        ConsoleLogger.log(
                "Main",
                "Перевірка обробки неповних даних"
        );

        try {
            FlightPlanBuilder builder =
                    new ConcreteFlightPlanBuilder();

            FlightPlan plan = builder
                    .setRoute("Чернівці - Київ")
                    .setWeatherReport("Ясно, вітер 3 м/с")
                    .build();

            System.out.println(plan);

        } catch (IllegalStateException e) {
            ConsoleLogger.log("Builder", e.getMessage());
        }
    }
}
