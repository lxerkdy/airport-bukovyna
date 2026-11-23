import chainofresponsibility.*;
import command.*;
import common.ConsoleLogger;

import java.time.LocalTime;

public class Main {

    private static void processPassenger(Passenger passenger) {
        System.out.println();
        ConsoleLogger.log(
                "Airport",
                "Початок передпольотного контролю"
        );

        ConsoleLogger.log(
                "Airport",
                "Пасажир: " + passenger.getName()
                        + " | Рейс: " + passenger.getFlightNumber()
                        + " | Тип: " + passenger.getFlightType()
        );

        CheckHandler chain =
                PreFlightChainFactory.createChain(passenger.getFlightType());

        chain.handle(passenger);

        System.out.println("----------------------------------------");
    }

    private static void runPreFlightControl() {
        ConsoleLogger.log("Main", "=== Завдання 1: Chain of Responsibility ===");

        Passenger passenger1 = new Passenger(
                "Олександр",
                "PS-101",
                FlightType.DOMESTIC,
                true,
                true,
                false,
                7.5
        );

        Passenger passenger2 = new Passenger(
                "Марія",
                "PS-202",
                FlightType.INTERNATIONAL,
                true,
                true,
                false,
                6.0
        );

        Passenger passenger3 = new Passenger(
                "Андрій",
                "PS-303",
                FlightType.DOMESTIC,
                false,
                true,
                false,
                5.0
        );

        Passenger passenger4 = new Passenger(
                "Ірина",
                "PS-404",
                FlightType.INTERNATIONAL,
                true,
                false,
                false,
                6.0
        );

        Passenger passenger5 = new Passenger(
                "Дмитро",
                "PS-505",
                FlightType.DOMESTIC,
                true,
                true,
                true,
                5.0
        );

        Passenger passenger6 = new Passenger(
                "Софія",
                "PS-606",
                FlightType.INTERNATIONAL,
                true,
                true,
                false,
                12.0
        );

        processPassenger(passenger1);
        processPassenger(passenger2);
        processPassenger(passenger3);
        processPassenger(passenger4);
        processPassenger(passenger5);
        processPassenger(passenger6);
    }

    private static void runDispatcherOperations() {
        System.out.println();
        ConsoleLogger.log("Main", "=== Завдання 2: Command ===");

        Schedule schedule = new Schedule();
        schedule.addFlight(new Flight("PS-101", LocalTime.of(10, 0), "A1"));
        schedule.addFlight(new Flight("PS-202", LocalTime.of(12, 0), "B2"));
        schedule.addFlight(new Flight("PS-303", LocalTime.of(14, 0), "C3"));
        DispatcherConsole dispatcher = new DispatcherConsole("Петренко");

        ConsoleLogger.log("Main", "--- Початковий розклад ---");
        schedule.print();

        ConsoleLogger.log("Main", "--- Дві зміни диспетчера ---");
        dispatcher.execute(new RescheduleFlightCommand(schedule, "PS-101", LocalTime.of(15, 30)));
        dispatcher.execute(new ChangeGateCommand(schedule, "PS-202", "B5"));
        schedule.print();

        ConsoleLogger.log("Main", "--- Скасування двох останніх дій ---");
        dispatcher.undoLast();
        dispatcher.undoLast();
        schedule.print();

        ConsoleLogger.log("Main", "--- Пакет із 3 підготовлених змін ---");
        dispatcher.enqueue(new ChangeGateCommand(schedule, "PS-303", "C7"));
        dispatcher.enqueue(new RescheduleFlightCommand(schedule, "PS-202", LocalTime.of(18, 45)));
        dispatcher.enqueue(new CancelFlightCommand(schedule, "PS-101"));
        dispatcher.executeBatch();
        schedule.print();

        System.out.println();
        dispatcher.printJournal();
    }

    public static void main(String[] args) {
        runPreFlightControl();
        runDispatcherOperations();
    }
}
