package command;

import java.time.LocalTime;

public class RescheduleFlightCommand implements ScheduleCommand {
    private final Schedule schedule;
    private final String flightNumber;
    private final LocalTime newTime;
    private LocalTime oldTime;

    public RescheduleFlightCommand(Schedule schedule, String flightNumber, LocalTime newTime) {
        this.schedule = schedule;
        this.flightNumber = flightNumber;
        this.newTime = newTime;
    }

    @Override
    public void execute() {
        Flight flight = schedule.getFlight(flightNumber);
        oldTime = flight.getDepartureTime();
        flight.setDepartureTime(newTime);
    }

    @Override
    public void undo() {
        schedule.getFlight(flightNumber).setDepartureTime(oldTime);
    }

    @Override
    public String describe() {
        return "Перенести рейс " + flightNumber + " на " + newTime;
    }
}
