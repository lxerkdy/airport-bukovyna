package decorator;

public class ExtraBaggage extends TicketDecorator {

    private final double additionalPrice;

    public ExtraBaggage(Ticket ticket) {
        super(ticket);
        this.additionalPrice = 500;
    }

    @Override
    public String getDescription() {
        return ticket.getDescription() + ", додатковий багаж";
    }

    @Override
    public double getPrice() {
        return ticket.getPrice() + additionalPrice;
    }
}
