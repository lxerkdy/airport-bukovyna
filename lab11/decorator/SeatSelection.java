package decorator;

public class SeatSelection extends TicketDecorator {

    private final String seatNumber;
    private final double additionalPrice;

    public SeatSelection(Ticket ticket, String seatNumber) {
        super(ticket);
        this.seatNumber = seatNumber;
        this.additionalPrice = 150;
    }

    @Override
    public String getDescription() {
        return ticket.getDescription()
                + ", вибір місця " + seatNumber;
    }

    @Override
    public double getPrice() {
        return ticket.getPrice() + additionalPrice;
    }
}
