import common.ConsoleLogger;

import composite.Cargo;
import composite.CargoItem;
import composite.CargoGroup;

import flyweight.Seat;
import flyweight.SeatType;
import flyweight.SeatTypeFactory;
import flyweight.SeatTypeFactory.SeatTypeType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        runCompositeScenario();

        System.out.println();

        runFlyweightScenario();
    }

    // ==========================================
    // ЗАВДАННЯ 1. COMPOSITE
    // ==========================================

    private static void runCompositeScenario() {

        ConsoleLogger.log("Main", "========== COMPOSITE ==========");

        // Літак
        CargoGroup aircraft = new CargoGroup("Літак PS-101");

        // Два багажні відсіки
        CargoGroup compartment1 = new CargoGroup("Багажний відсік 1");
        CargoGroup compartment2 = new CargoGroup("Багажний відсік 2");

        // Контейнери першого відсіку
        CargoGroup container1 = new CargoGroup("Контейнер C-001");
        CargoGroup container2 = new CargoGroup("Контейнер C-002");

        // Контейнери другого відсіку
        CargoGroup container3 = new CargoGroup("Контейнер C-003");

        // Окремі вантажі
        container1.add(new CargoItem("Валіза A", 23));
        container1.add(new CargoItem("Валіза B", 18));
        container1.add(new CargoItem("Посилка P-001", 12));

        // Палета всередині контейнера
        CargoGroup pallet = new CargoGroup("Палета PL-001");

        pallet.add(new CargoItem("Посилка P-002", 15));
        pallet.add(new CargoItem("Посилка P-003", 20));
        pallet.add(new CargoItem("Посилка P-004", 10));

        container2.add(new CargoItem("Валіза C", 25));
        container2.add(pallet);

        container3.add(new CargoItem("Валіза D", 21));
        container3.add(new CargoItem("Валіза E", 19));
        container3.add(new CargoItem("Посилка P-005", 8));

        // Формуємо відсіки
        compartment1.add(container1);
        compartment1.add(container2);

        compartment2.add(container3);

        // Формуємо літак
        aircraft.add(compartment1);
        aircraft.add(compartment2);

        // Виведення всієї структури
        ConsoleLogger.log("Main", "Структура вантажу літака:");

        aircraft.printTree("");

        // Загальна вага літака
        ConsoleLogger.log(
                "Main",
                "Загальна вага літака: "
                        + aircraft.getWeight() + " кг"
        );

        // Вага першого відсіку
        ConsoleLogger.log(
                "Main",
                "Вага першого відсіку: "
                        + compartment1.getWeight() + " кг"
        );

        // Кількість окремих вантажних місць
        ConsoleLogger.log(
                "Main",
                "Загальна кількість вантажних місць: "
                        + aircraft.getPieceCount()
        );
    }

    // ==========================================
    // ЗАВДАННЯ 2. FLYWEIGHT
    // ==========================================

    private static void runFlyweightScenario() {

        ConsoleLogger.log("Main", "========== FLYWEIGHT ==========");

        SeatTypeFactory factory = new SeatTypeFactory();

        Map<String, List<Seat>> flights = new HashMap<>();

        int totalSeatObjects = 0;

        // Створюємо схеми 20 рейсів по 180 місць
        for (int flightNumber = 1; flightNumber <= 20; flightNumber++) {

            String flightCode = String.format("PS-%03d", 100 + flightNumber);

            List<Seat> seats = new ArrayList<>();

            // 30 рядів по 6 місць
            for (int row = 1; row <= 30; row++) {

                for (char letter = 'A'; letter <= 'F'; letter++) {

                    SeatTypeType type;

                    if (row <= 5) {
                        type = SeatTypeType.BUSINESS;
                    } else if (row <= 10) {
                        type = SeatTypeType.COMFORT;
                    } else {
                        type = SeatTypeType.ECONOMY;
                    }

                    // Отримуємо спільний об'єкт класу
                    SeatType SeatType = factory.getSeatType(type);

                    String passengerName = "Не призначено";

                    // Для демонстрації призначимо пасажирів на два місця
                    if (flightNumber == 1 && row == 1 && letter == 'A') {
                        passengerName = "Іваненко Іван";
                    }

                    if (flightNumber == 2 && row == 1 && letter == 'A') {
                        passengerName = "Петренко Олена";
                    }

                    Seat seat = new Seat(
                            row,
                            letter,
                            passengerName,
                            SeatType
                    );

                    seats.add(seat);
                    totalSeatObjects++;
                }
            }

            flights.put(flightCode, seats);

            ConsoleLogger.log(
                    "Main",
                    "Створено схему рейсу " + flightCode
                            + ": " + seats.size() + " місць"
            );
        }

        // Кількість створених об'єктів
        ConsoleLogger.log(
                "Main",
                "Загальна кількість об'єктів місць: "
                        + totalSeatObjects
        );

        ConsoleLogger.log(
                "Main",
                "Кількість об'єктів класів обслуговування: "
                        + factory.getCreatedClassesCount()
        );

        // Два VIP-місця на різних рейсах
        Seat firstSeat = flights.get("PS-101").get(0);
        Seat secondSeat = flights.get("PS-102").get(0);

        ConsoleLogger.log("Main", "Опис першого місця:");

        firstSeat.printDetails("PS-101");

        ConsoleLogger.log("Main", "Опис другого місця:");

        secondSeat.printDetails("PS-102");

        // Перевірка спільного об'єкта
        boolean sameClassObject =
                firstSeat.getSeatType() == secondSeat.getSeatType();

        ConsoleLogger.log(
                "Main",
                "Чи використовують місця один об'єкт класу: "
                        + sameClassObject
        );

        ConsoleLogger.log(
                "Main",
                "Identity першого об'єкта: "
                        + System.identityHashCode(firstSeat.getSeatType())
        );

        ConsoleLogger.log(
                "Main",
                "Identity другого об'єкта: "
                        + System.identityHashCode(secondSeat.getSeatType())
        );
    }
}