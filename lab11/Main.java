
import common.ConsoleLogger;

import adapter.*;
import decorator.*;
import facade.PassengerRegistrationFacade;
import proxy.*;

public class Main {

    public static void main(String[] args) {
        runAdapterScenario();
        System.out.println();

        runDecoratorScenario();
        System.out.println();

        runFacadeScenario();
        System.out.println();

        runProxyScenario();
    }

    // Завдання 1. Adapter
    private static void runAdapterScenario() {
        ConsoleLogger.log("Main", "========== ADAPTER ==========");

        // Перший метеопостачальник:
        // Fahrenheit, knots, miles
        ConsoleLogger.log("Main", "=== Перший метеопостачальник ===");

        WeatherProvider firstProvider =
                new WeatherAdapter(new InternationalWeatherService());

        FlightControlCenter firstCenter =
                new FlightControlCenter(firstProvider);

        firstCenter.checkWeatherForTakeoff("PS-101");


        // Другий метеопостачальник:
        // Kelvin, km/h, feet
        ConsoleLogger.log("Main", "=== Другий метеопостачальник ===");

        WeatherProvider secondProvider =
                new SecondWeatherAdapter(new SecondWeatherService());

        FlightControlCenter secondCenter =
                new FlightControlCenter(secondProvider);

        secondCenter.checkWeatherForTakeoff("PS-202");
    }

    // Завдання 2. Decorator
    private static void runDecoratorScenario() {
        ConsoleLogger.log("Main", "========== DECORATOR ==========");

        // Перший квиток:
        // базовий квиток + багаж + страхування + пріоритетна посадка
        ConsoleLogger.log("Main", "=== Перший квиток ===");

        Ticket firstTicket =
                new BasicTicket("PS-101", "Іван", 2500);

        firstTicket = new ExtraBaggage(firstTicket);
        firstTicket = new Insurance(firstTicket);
        firstTicket = new PriorityBoarding(firstTicket);

        printTicket(firstTicket);


        // Другий квиток:
        // базовий квиток + два харчування + вибір місця
        ConsoleLogger.log("Main", "=== Другий квиток ===");

        Ticket secondTicket =
                new BasicTicket("PS-202", "Олександр", 3000);

        secondTicket = new MealService(secondTicket);
        secondTicket = new MealService(secondTicket);
        secondTicket = new SeatSelection(secondTicket, "12A");

        printTicket(secondTicket);
    }

    // Виведення інформації про квиток
    private static void printTicket(Ticket ticket) {
        ConsoleLogger.log("Main",
                "Опис: " + ticket.getDescription());

        ConsoleLogger.log("Main",
                String.format(
                        "Загальна вартість: %.2f грн",
                        ticket.getPrice()
                ));
    }

    // Завдання 3. Facade
    private static void runFacadeScenario() {
        ConsoleLogger.log("Main", "========== FACADE ==========");
        PassengerRegistrationFacade registration =
                new PassengerRegistrationFacade();
        registration.registerPassenger("Марія", "AB123456",
                "PS-303", "14B", 18.5);
        registration.reprintBoardingPass("Марія", "PS-303", "14B");
    }

    // Завдання 4. Proxy
    private static void runProxyScenario() {
        ConsoleLogger.log("Main", "========== PROXY ==========");
        FlightLogProxy proxy = new FlightLogProxy();
        FlightReportModule reports = new FlightReportModule(proxy);

        // Заборонений запит не завантажує архів.
        reports.showTelemetry("PS-101", UserRole.CASHIER);
        reports.showTelemetry("PS-101", UserRole.DISPATCHER);
        reports.showTelemetry("PS-202", UserRole.SAFETY);
    }
}
