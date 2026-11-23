package command;

public class CancelFlightCommand implements ScheduleCommand {
    private final Schedule schedule;
    private final String flightNumber;
    private boolean wasCancelled;

    public CancelFlightCommand(Schedule schedule, String flightNumber) {
        this.schedule = schedule;
        this.flightNumber = flightNumber;
    }

    @Override
    public void execute() {
        Flight flight = schedule.getFlight(flightNumber);
        wasCancelled = flight.isCancelled();
        flight.setCancelled(true);
    }

    @Override
    public void undo() {
        schedule.getFlight(flightNumber).setCancelled(wasCancelled);
    }

    @Override
    public String describe() {
        return "Скасувати рейс " + flightNumber;
    }
}
