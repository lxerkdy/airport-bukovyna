
package prototype;

import common.ConsoleLogger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flight {

    private String flightNumber;
    private final String route;
    private LocalDate date;

    private AircraftConfiguration aircraft;
    private List<Passenger> passengers;

    public Flight(
            String flightNumber,
            String route,
            LocalDate date,
            AircraftConfiguration aircraft,
            List<Passenger> passengers
    ) {
        this.flightNumber = flightNumber;
        this.route = route;
        this.date = date;
        this.aircraft = aircraft;
        this.passengers = passengers;
    }

    // Створення незалежної копії рейсу
    public Flight copyFor(String newFlightNumber, LocalDate newDate) {

        ConsoleLogger.log(
                "Prototype",
                "Створення копії рейсу " + newFlightNumber
        );

        return new Flight(
                newFlightNumber,
                route,
                newDate,
                aircraft.deepCopy(),
                copyPassengers()
        );
    }

    private List<Passenger> copyPassengers() {
        List<Passenger> copiedPassengers = new ArrayList<>();

        for (Passenger passenger : passengers) {
            copiedPassengers.add(passenger.deepCopy());
        }

        return copiedPassengers;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void blockSeat(String seatNumber) {
        aircraft.cabin.blockSeat(seatNumber);
    }

    public void changeMealMenu(List<String> newMeals) {
        aircraft.mealMenu.setMeals(newMeals);
    }

    public void printInfo() {
        System.out.println("\n--------------------------------");
        System.out.println("Рейс: " + flightNumber);
        System.out.println("Маршрут: " + route);
        System.out.println("Дата: " + date);
        System.out.println("Літак: " + aircraft.aircraftType);
        System.out.println("Екіпаж: " + aircraft.crew);
        System.out.println("Норми багажу: " + aircraft.baggageNorms);
        System.out.println("Меню: " + aircraft.mealMenu.meals);

        System.out.println("Пасажири:");

        for (Passenger passenger : passengers) {
            System.out.println("  " + passenger);
        }

        System.out.println("Салон:");

        for (Seat seat : aircraft.cabin.seats) {
            System.out.println("  " + seat);
        }

        System.out.println("--------------------------------");
    }

    // Конфігурація літака
    public static class AircraftConfiguration {

        private final String aircraftType;
        private final CabinLayout cabin;
        private final List<String> crew;
        private final Map<String, Integer> baggageNorms;
        private final MealMenu mealMenu;

        public AircraftConfiguration(
                String aircraftType,
                CabinLayout cabin,
                List<String> crew,
                Map<String, Integer> baggageNorms,
                MealMenu mealMenu
        ) {
            this.aircraftType = aircraftType;
            this.cabin = cabin;
            this.crew = crew;
            this.baggageNorms = baggageNorms;
            this.mealMenu = mealMenu;
        }

        public AircraftConfiguration deepCopy() {
            return new AircraftConfiguration(
                    aircraftType,
                    cabin.deepCopy(),
                    new ArrayList<>(crew),
                    new HashMap<>(baggageNorms),
                    mealMenu.deepCopy()
            );
        }
    }

    // Конфігурація салону
    public static class CabinLayout {

        private final List<Seat> seats;

        public CabinLayout(List<Seat> seats) {
            this.seats = seats;
        }

        public void blockSeat(String seatNumber) {
            for (Seat seat : seats) {
                if (seat.number.equals(seatNumber)) {
                    seat.blocked = true;
                    ConsoleLogger.log(
                            "CabinLayout",
                            "Місце " + seatNumber + " заблоковано"
                    );
                    return;
                }
            }

            ConsoleLogger.log(
                    "CabinLayout",
                    "Місце " + seatNumber + " не знайдено"
            );
        }

        public CabinLayout deepCopy() {
            List<Seat> copiedSeats = new ArrayList<>();

            for (Seat seat : seats) {
                copiedSeats.add(seat.deepCopy());
            }

            return new CabinLayout(copiedSeats);
        }
    }

    // Місце в літаку
    public static class Seat {

        private final String number;
        private boolean blocked;

        public Seat(String number) {
            this.number = number;
            this.blocked = false;
        }

        public Seat deepCopy() {
            Seat copy = new Seat(number);
            copy.blocked = blocked;
            return copy;
        }

        @Override
        public String toString() {
            return number + (blocked ? " [ЗАБЛОКОВАНО]" : " [ВІЛЬНЕ]");
        }
    }

    // Пасажир
    public static class Passenger {

        private final String name;
        private final String seatNumber;

        public Passenger(String name, String seatNumber) {
            this.name = name;
            this.seatNumber = seatNumber;
        }

        public Passenger deepCopy() {
            return new Passenger(name, seatNumber);
        }

        @Override
        public String toString() {
            return name + ", місце " + seatNumber;
        }
    }

    // Меню харчування
    public static class MealMenu {

        private List<String> meals;

        public MealMenu(List<String> meals) {
            this.meals = meals;
        }

        public void setMeals(List<String> meals) {
            this.meals = new ArrayList<>(meals);
        }

        public MealMenu deepCopy() {
            return new MealMenu(new ArrayList<>(meals));
        }
    }
}
