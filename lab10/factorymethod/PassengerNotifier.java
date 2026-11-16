package factorymethod;

import common.ConsoleLogger;

// Creator: загальний процес сповіщення описано один раз.
// Конкретне повідомлення створює підклас у фабричному методі createMessage.
public abstract class PassengerNotifier {

    public final void notifyPassengers(String flightNumber, String details) {
        ConsoleLogger.log("Сповіщення",
                "Рейс " + flightNumber + ": " + details);

        // 1. Сформувати повідомлення (фабричний метод)
        NotificationMessage message = createMessage(flightNumber, details);

        ConsoleLogger.log("Сповіщення",
                "Сформовано повідомлення для каналу «"
                        + message.getChannelName() + "»");

        // 2. Надіслати
        message.send();

        // 3. Записати в журнал
        ConsoleLogger.log("Журнал сповіщень",
                "Рейс " + flightNumber + " | канал «"
                        + message.getChannelName() + "» | доставлено");
    }

    // Factory Method
    protected abstract NotificationMessage createMessage(
            String flightNumber, String details);
}
