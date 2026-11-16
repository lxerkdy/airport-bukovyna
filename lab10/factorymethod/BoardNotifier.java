package factorymethod;

public class BoardNotifier extends PassengerNotifier {

    @Override
    protected NotificationMessage createMessage(
            String flightNumber, String details) {
        return new BoardMessage(flightNumber, details);
    }
}
