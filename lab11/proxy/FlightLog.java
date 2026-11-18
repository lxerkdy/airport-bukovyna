package proxy;

import java.util.List;

public interface FlightLog {

    List<String> getFlightNumbers();

    String getTelemetry(String flightNumber, UserRole role);
}
