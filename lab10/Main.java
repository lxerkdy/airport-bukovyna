import builder.ConcreteFlightPlanBuilder;
import builder.FlightPlan;
import builder.FlightPlanBuilder;
import builder.FlightPlanDirector;

import abstractfactory.AirbusA320Factory;
import abstractfactory.ATR72Factory;
import abstractfactory.WideBodyFactory;
import abstractfactory.GroundHandlingDispatcher;

import common.ConsoleLogger;

public class Main {

    public static void main(String[] args) {
        runBuilderScenario();
        runAbstractFactoryScenario();
    }

    // Завдання 1. Builder
    private static void runBuilderScenario() {
        ConsoleLogger.log("Main", "=== BUILDER ===");

        FlightPlanDirector director = new FlightPlanDirector();

        // Повне польотне завдання для пасажирського рейсу
        ConsoleLogger.log("Main", "Створення пасажирського рейсу PS-101");

        FlightPlanBuilder passengerBuilder = new ConcreteFlightPlanBuilder();

        FlightPlan passengerPlan =
                director.createRegularPassengerFlight(passengerBuilder);

        ConsoleLogger.log("Main", passengerPlan.toString());

        // Мінімальне польотне завдання для навчального рейсу
        ConsoleLogger.log("Main", "Створення навчального рейсу TR-202");

        FlightPlanBuilder trainingBuilder = new ConcreteFlightPlanBuilder();

        FlightPlan trainingPlan =
                director.createTrainingFlight(trainingBuilder);

        ConsoleLogger.log("Main", trainingPlan.toString());

        // Спроба створити завдання без обов'язкового розрахунку палива
        ConsoleLogger.log("Main",
                "Перевірка обробки помилки: відсутній розрахунок палива");

        try {
            new ConcreteFlightPlanBuilder()
                    .setRoute("Чернівці — Київ")
                    .setWeatherReport("Погодні умови сприятливі")
                    .build();

        } catch (IllegalStateException exception) {
            ConsoleLogger.log("Builder", exception.getMessage());
        }
    }

    // Завдання 2. Abstract Factory
    private static void runAbstractFactoryScenario() {
        ConsoleLogger.log("Main", "=== ABSTRACT FACTORY ===");

        GroundHandlingDispatcher dispatcher =
                new GroundHandlingDispatcher();

        // Обслуговування рейсу на Airbus A320
        dispatcher.dispatch("BUK-101", new AirbusA320Factory());

        // Обслуговування рейсу на ATR-72
        dispatcher.dispatch("BUK-202", new ATR72Factory());

        // Обслуговування широкофюзеляжного літака
        dispatcher.dispatch("BUK-303", new WideBodyFactory());
    }
}