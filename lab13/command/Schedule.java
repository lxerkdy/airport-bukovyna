package command;

import common.ConsoleLogger;

import java.util.LinkedHashMap;
import java.util.Map;

public class Schedule {
    private final Map<String, Flight> flights = new LinkedHashMap<>();

    public void addFlight(Flight flight) {
        flights.put(flight.getFlightNumber(), flight);
    }

    public Flight getFlight(String flightNumber) {
        Flight flight = flights.get(flightNumber);
        if (flight == null) {
            throw new IllegalArgumentException("Рейс не знайдено: " + flightNumber);
        }
        return flight;
    }

    public void print() {
        ConsoleLogger.log("Schedule", "Поточний розклад:");
        for (Flight flight : flights.values()) {
            ConsoleLogger.log("Schedule", "  " + flight);
        }
    }
}
