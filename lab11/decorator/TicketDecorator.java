package decorator;

public abstract class TicketDecorator implements Ticket {

    protected final Ticket ticket;

    public TicketDecorator(Ticket ticket) {
        this.ticket = ticket;
    }
}
