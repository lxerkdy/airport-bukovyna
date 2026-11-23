package command;

public class ChangeGateCommand implements ScheduleCommand {
    private final Schedule schedule;
    private final String flightNumber;
    private final String newGate;
    private String oldGate;

    public ChangeGateCommand(Schedule schedule, String flightNumber, String newGate) {
        this.schedule = schedule;
        this.flightNumber = flightNumber;
        this.newGate = newGate;
    }

    @Override
    public void execute() {
        Flight flight = schedule.getFlight(flightNumber);
        oldGate = flight.getGate();
        flight.setGate(newGate);
    }

    @Override
    public void undo() {
        schedule.getFlight(flightNumber).setGate(oldGate);
    }

    @Override
    public String describe() {
        return "Змінити вихід рейсу " + flightNumber + " на " + newGate;
    }
}
