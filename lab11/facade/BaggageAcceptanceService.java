package facade;

import common.ConsoleLogger;

public class BaggageAcceptanceService {

    public void acceptBaggage(String passengerName, double baggageWeight) {
        ConsoleLogger.log("BaggageAcceptanceService",
                "Прийом багажу пасажира " + passengerName
                        + ", вага: " + baggageWeight + " кг");
    }
}
