package proxy;

import common.ConsoleLogger;
import java.util.List;
import java.util.Map;

public class RealFlightLogArchive implements FlightLog {

    private final Map<String, String> telemetryRecords;

    public RealFlightLogArchive() {
        ConsoleLogger.log("RealFlightLogArchive",
                "Початок завантаження архіву телеметрії...");
        telemetryRecords = Map.of(
                "PS-101", "Висота: 10500 м, швидкість: 820 км/год",
                "PS-202", "Висота: 9800 м, швидкість: 790 км/год",
                "PS-303", "Висота: 11200 м, швидкість: 840 км/год");
        ConsoleLogger.log("RealFlightLogArchive",
                "Архів телеметрії завантажено");
    }

    @Override
    public List<String> getFlightNumbers() {
        return List.copyOf(telemetryRecords.keySet());
    }

    @Override
    public String getTelemetry(String flightNumber, UserRole role) {
        return telemetryRecords.getOrDefault(flightNumber,
                "Запис для рейсу " + flightNumber + " не знайдено");
    }
}
