package proxy;

import common.ConsoleLogger;
import java.util.List;

public class FlightLogProxy implements FlightLog {

    private RealFlightLogArchive archive;

    private RealFlightLogArchive getArchive() {
        if (archive == null) {
            archive = new RealFlightLogArchive();
        }
        return archive;
    }

    private boolean hasAccess(UserRole role) {
        return role == UserRole.DISPATCHER || role == UserRole.SAFETY;
    }

    @Override
    public List<String> getFlightNumbers() {
        return getArchive().getFlightNumbers();
    }

    @Override
    public String getTelemetry(String flightNumber, UserRole role) {
        ConsoleLogger.log("FlightLogProxy",
                "Перевірка доступу для ролі " + role);
        if (!hasAccess(role)) {
            ConsoleLogger.log("FlightLogProxy",
                    "Доступ до телеметрії заборонено");
            return "Доступ заборонено";
        }
        ConsoleLogger.log("FlightLogProxy",
                "Доступ до телеметрії дозволено");
        return getArchive().getTelemetry(flightNumber, role);
    }
}
