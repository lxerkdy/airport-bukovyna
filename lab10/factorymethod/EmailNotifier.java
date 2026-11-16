package factorymethod;

public class EmailNotifier extends PassengerNotifier {

    @Override
    protected NotificationMessage createMessage(
            String flightNumber, String details) {
        return new EmailMessage(flightNumber, details);
    }
}
