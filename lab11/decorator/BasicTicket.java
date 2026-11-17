package decorator;

public class BasicTicket implements Ticket {

    private final String flightNumber;
    private final String passengerName;
    private final double basePrice;

    public BasicTicket(String flightNumber, String passengerName,
                       double basePrice) {
        this.flightNumber = flightNumber;
        this.passengerName = passengerName;
        this.basePrice = basePrice;
    }

    @Override
    public String getDescription() {
        return "Квиток на рейс " + flightNumber
                + ", пасажир: " + passengerName;
    }

    @Override
    public double getPrice() {
        return basePrice;
    }
}
