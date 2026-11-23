package command;

import java.time.LocalTime;

public class Flight {
    private final String flightNumber;
    private LocalTime departureTime;
    private String gate;
    private boolean cancelled;

    public Flight(String flightNumber, LocalTime departureTime, String gate) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.gate = gate;
        this.cancelled = false;
    }

    public String getFlightNumber() { return flightNumber; }
    public LocalTime getDepartureTime() { return departureTime; }
    public String getGate() { return gate; }
    public boolean isCancelled() { return cancelled; }

    public void setDepartureTime(LocalTime departureTime) { this.departureTime = departureTime; }
    public void setGate(String gate) { this.gate = gate; }
    public void setCancelled(boolean cancelled) { this.cancelled = cancelled; }

    @Override
    public String toString() {
        return flightNumber + " | вильот " + departureTime + " | вихід " + gate
                + (cancelled ? " | СКАСОВАНО" : "");
    }
}
