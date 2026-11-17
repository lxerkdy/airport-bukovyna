package decorator;

public class MealService extends TicketDecorator {

    private final double additionalPrice;

    public MealService(Ticket ticket) {
        super(ticket);
        this.additionalPrice = 250;
    }

    @Override
    public String getDescription() {
        return ticket.getDescription() + ", харчування";
    }

    @Override
    public double getPrice() {
        return ticket.getPrice() + additionalPrice;
    }
}
