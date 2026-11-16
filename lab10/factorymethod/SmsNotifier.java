package factorymethod;

public class SmsNotifier extends PassengerNotifier {

    @Override
    protected NotificationMessage createMessage(
            String flightNumber, String details) {
        return new SmsMessage(flightNumber, details);
    }
}
