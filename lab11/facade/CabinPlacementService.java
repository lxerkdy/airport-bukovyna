package facade;

import common.ConsoleLogger;
import java.util.HashSet;
import java.util.Set;

public class CabinPlacementService {

    private final Set<String> reservedSeats = new HashSet<>();

    public boolean assignSeat(String passengerName, String flightNumber,
                              String seatNumber) {
        ConsoleLogger.log("CabinPlacementService",
                "Пошук місця " + seatNumber + " для пасажира " + passengerName);
        String seatKey = flightNumber + "-" + seatNumber;
        if (reservedSeats.contains(seatKey)) {
            ConsoleLogger.log("CabinPlacementService",
                    "Місце " + seatNumber + " вже зайняте");
            return false;
        }
        reservedSeats.add(seatKey);
        ConsoleLogger.log("CabinPlacementService",
                "Місце " + seatNumber + " призначено для рейсу " + flightNumber);
        return true;
    }
}
