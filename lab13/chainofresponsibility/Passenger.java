package chainofresponsibility;

public class Passenger {
    private final String name;
    private final String flightNumber;
    private final FlightType flightType;

    private final boolean boardingPassValid;
    private final boolean passportValid;
    private final boolean hasProhibitedItems;
    private final double handLuggageWeight;

    public Passenger(
            String name,
            String flightNumber,
            FlightType flightType,
            boolean boardingPassValid,
            boolean passportValid,
            boolean hasProhibitedItems,
            double handLuggageWeight
    ) {
        this.name = name;
        this.flightNumber = flightNumber;
        this.flightType = flightType;
        this.boardingPassValid = boardingPassValid;
        this.passportValid = passportValid;
        this.hasProhibitedItems = hasProhibitedItems;
        this.handLuggageWeight = handLuggageWeight;
    }

    public String getName() {
        return name;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public boolean hasValidBoardingPass() {
        return boardingPassValid;
    }

    public boolean hasValidPassport() {
        return passportValid;
    }

    public boolean hasProhibitedItems() {
        return hasProhibitedItems;
    }

    public double getHandLuggageWeight() {
        return handLuggageWeight;
    }
}