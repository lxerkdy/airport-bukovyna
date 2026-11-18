package facade;

import common.ConsoleLogger;

public class BorderServiceNotifier {

    public void notifyRegistration(String passengerName, String flightNumber) {
        ConsoleLogger.log("BorderServiceNotifier",
                "Прикордонну службу повідомлено про реєстрацію "
                        + passengerName + " на рейс " + flightNumber);
    }
}
