package decorator;

public class Insurance extends TicketDecorator {

    private final double additionalPrice;

    public Insurance(Ticket ticket) {
        super(ticket);
        this.additionalPrice = 300;
    }

    @Override
    public String getDescription() {
        return ticket.getDescription() + ", страхування";
    }

    @Override
    public double getPrice() {
        return ticket.getPrice() + additionalPrice;
    }
}
