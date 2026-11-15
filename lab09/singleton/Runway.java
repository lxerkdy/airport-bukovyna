package singleton;

public class Runway {

    private final int number;
    private String flightNumber;
    private String operation;

    public Runway(int number) {
        this.number = number;
        this.flightNumber = null;
        this.operation = null;
    }

    public int getNumber() {
        return number;
    }

    public boolean isFree() {
        return flightNumber == null;
    }

    public boolean reserve(String flightNumber, String operation) {
        if (!isFree()) {
            return false;
        }

        this.flightNumber = flightNumber;
        this.operation = operation;

        return true;
    }

    public void release() {
        flightNumber = null;
        operation = null;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getOperation() {
        return operation;
    }
}
