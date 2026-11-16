
import common.ConsoleLogger;
import singleton.FlightControlCenter;

import prototype.Flight;
import prototype.Flight.AircraftConfiguration;
import prototype.Flight.CabinLayout;
import prototype.Flight.MealMenu;
import prototype.Flight.Passenger;
import prototype.Flight.Seat;

import pool.JetwayPool;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        runSingletonScenario();
        runPrototypeScenario();
        runPoolScenario();
    }

    private static void runSingletonScenario() {
        ConsoleLogger.log("Main", "=== Завдання 1: Singleton ===");

        // Модуль прибуття
        FlightControlCenter arrivalsCenter =
                FlightControlCenter.getInstance();

        ConsoleLogger.log(
                "Arrivals",
                "Отримано центр керування: "
                        + System.identityHashCode(arrivalsCenter)
        );

        arrivalsCenter.requestPermission(
                1,
                "PS-101",
                "посадку"
        );

        // Модуль відправлення
        FlightControlCenter departuresCenter =
                FlightControlCenter.getInstance();

        ConsoleLogger.log(
                "Departures",
                "Отримано центр керування: "
                        + System.identityHashCode(departuresCenter)
        );

        departuresCenter.requestPermission(
                1,
                "PS-202",
                "зліт"
        );

        // Звільняємо смугу
        arrivalsCenter.releaseRunway(1);
    }

    private static void runPrototypeScenario() {
        ConsoleLogger.log("Main", "=== Завдання 2: Prototype ===");

        // Імітуємо дороге завантаження конфігурації літака
        ConsoleLogger.log(
                "AircraftLoader",
                "Завантаження конфігурації Airbus A320..."
        );

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        ConsoleLogger.log(
                "AircraftLoader",
                "Конфігурацію літака завантажено"
        );

        // Створюємо салон
        List<Seat> seats = new ArrayList<>();

        seats.add(new Seat("12A"));
        seats.add(new Seat("12B"));
        seats.add(new Seat("12C"));
        seats.add(new Seat("13A"));
        seats.add(new Seat("13B"));

        CabinLayout cabin = new CabinLayout(seats);

        // Екіпаж
        List<String> crew = new ArrayList<>(
                List.of("Капітан", "Другий пілот", "Бортпровідник")
        );

        // Норми багажу
        Map<String, Integer> baggageNorms = new HashMap<>();
        baggageNorms.put("Ручна поклажа", 8);
        baggageNorms.put("Зареєстрований багаж", 23);

        // Меню
        MealMenu menu = new MealMenu(
                new ArrayList<>(
                        List.of("Курка з рисом", "Овочевий салат")
                )
        );

        AircraftConfiguration aircraft = new AircraftConfiguration(
                "Airbus A320",
                cabin,
                crew,
                baggageNorms,
                menu
        );

        // Пасажири еталонного рейсу
        List<Passenger> passengers = new ArrayList<>();

        passengers.add(new Passenger("Іван Петренко", "12A"));
        passengers.add(new Passenger("Олена Коваль", "12B"));

        // Еталонний рейс
        Flight prototype = new Flight(
                "PS-100",
                "Чернівці - Варшава",
                LocalDate.of(2026, 11, 15),
                aircraft,
                passengers
        );

        ConsoleLogger.log(
                "Prototype",
                "Створено еталонний рейс PS-100"
        );

        // Створюємо три копії
        Flight flight1 = prototype.copyFor(
                "PS-101",
                LocalDate.of(2026, 11, 16)
        );

        Flight flight2 = prototype.copyFor(
                "PS-102",
                LocalDate.of(2026, 11, 17)
        );

        Flight flight3 = prototype.copyFor(
                "PS-103",
                LocalDate.of(2026, 11, 18)
        );

        // Змінюємо тільки першу копію
        flight1.changeMealMenu(
                List.of("Риба з овочами", "Фруктовий десерт")
        );

        flight1.addPassenger(
                new Passenger("Андрій Мельник", "12C")
        );

        flight1.blockSeat("12A");

        // Перевіряємо незалежність копій
        ConsoleLogger.log(
                "Prototype",
                "Перевірка незалежності копій"
        );

        System.out.println("\nЕТАЛОННИЙ РЕЙС:");
        prototype.printInfo();

        System.out.println("\nЗМІНЕНА КОПІЯ:");
        flight1.printInfo();

        System.out.println("\nДРУГА КОПІЯ:");
        flight2.printInfo();

        System.out.println("\nТРЕТЯ КОПІЯ:");
        flight3.printInfo();
    }

    private static void runPoolScenario() {
        ConsoleLogger.log("Main", "=== Завдання 3: Object Pool ===");

        // 3 телетрапи, у черзі може чекати 1 рейс, решта їде автобусом
        JetwayPool pool = new JetwayPool(3, 1);

        // 5 рейсів прибувають майже одночасно
        pool.request("PS-101");
        pool.request("PS-102");
        pool.request("PS-103");
        pool.request("PS-104");
        pool.request("PS-105");

        // PS-101 звільняє телетрап, його отримує PS-104 з черги
        pool.release("PS-101");

        // Звільнений T-2 видається новому рейсу без підготовки
        pool.release("PS-102");
        pool.request("PS-106");

        pool.printStatistics();
    }
}
