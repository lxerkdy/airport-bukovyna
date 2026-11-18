package proxy;

import common.ConsoleLogger;

public class FlightReportModule {

    private final FlightLog flightLog;

    public FlightReportModule(FlightLog flightLog) {
        this.flightLog = flightLog;
    }

    public void showTelemetry(String flightNumber, UserRole role) {
        ConsoleLogger.log("FlightReportModule",
                "Запит телеметрії рейсу " + flightNumber);
        String telemetry = flightLog.getTelemetry(flightNumber, role);
        ConsoleLogger.log("FlightReportModule", "Результат: " + telemetry);
    }
}
