import builder.ConcreteFlightPlanBuilder;
import builder.FlightPlan;
import builder.FlightPlanBuilder;
import builder.FlightPlanDirector;

import abstractfactory.AirbusA320Factory;
import abstractfactory.ATR72Factory;
import abstractfactory.WideBodyFactory;
import abstractfactory.GroundHandlingDispatcher;

import factorymethod.BoardNotifier;
import factorymethod.EmailNotifier;
import factorymethod.MobileAppNotifier;
import factorymethod.PassengerNotifier;
import factorymethod.SmsNotifier;

import common.ConsoleLogger;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        runBuilderScenario();
        runAbstractFactoryScenario();
        runFactoryMethodScenario();
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

    // Завдання 3. Factory Method
    private static void runFactoryMethodScenario() {
        ConsoleLogger.log("Main", "=== FACTORY METHOD ===");

        List<PassengerNotifier> notifiers = new ArrayList<>();
        notifiers.add(new SmsNotifier());
        notifiers.add(new EmailNotifier());
        notifiers.add(new BoardNotifier());

        // Затримка рейсу: SMS, e-mail і табло
        ConsoleLogger.log("Main", "Рейс PS-101 затримується на 40 хвилин");

        for (PassengerNotifier notifier : notifiers) {
            notifier.notifyPassengers("PS-101", "затримка рейсу на 40 хвилин");
        }

        // Новий канал: один клас каналу й один клас повідомлення,
        // загальний процес PassengerNotifier не змінюється
        ConsoleLogger.log("Main", "Підключено канал «Мобільний застосунок»");
        notifiers.add(new MobileAppNotifier());

        // Зміна виходу на посадку: усі чотири канали
        ConsoleLogger.log("Main", "Змінено вихід на посадку для рейсу PS-101");

        for (PassengerNotifier notifier : notifiers) {
            notifier.notifyPassengers("PS-101", "новий вихід на посадку: B3");
        }
    }
}
