package decorator;

public class PriorityBoarding extends TicketDecorator {

    private final double additionalPrice;

    public PriorityBoarding(Ticket ticket) {
        super(ticket);
        this.additionalPrice = 200;
    }

    @Override
    public String getDescription() {
        return ticket.getDescription() + ", пріоритетна посадка";
    }

    @Override
    public double getPrice() {
        return ticket.getPrice() + additionalPrice;
    }
}
