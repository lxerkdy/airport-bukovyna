package factorymethod;

public class MobileAppNotifier extends PassengerNotifier {

    @Override
    protected NotificationMessage createMessage(
            String flightNumber, String details) {
        return new MobileAppMessage(flightNumber, details);
    }
}
