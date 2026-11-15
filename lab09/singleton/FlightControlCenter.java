
package singleton;

import common.ConsoleLogger;

import java.util.HashMap;
import java.util.Map;

public class FlightControlCenter {

    private static final FlightControlCenter INSTANCE =
            new FlightControlCenter();

    private final Map<Integer, Runway> runways = new HashMap<>();

    private FlightControlCenter() {
        runways.put(1, new Runway(1));
        runways.put(2, new Runway(2));

        ConsoleLogger.log(
                "FlightControlCenter",
                "Центр керування польотами ініціалізовано"
        );
    }

    public static FlightControlCenter getInstance() {
        return INSTANCE;
    }

    public boolean requestPermission(
            int runwayNumber,
            String flightNumber,
            String operation
    ) {
        Runway runway = runways.get(runwayNumber);

        if (runway == null) {
            ConsoleLogger.log(
                    "FlightControlCenter",
                    "Смуги " + runwayNumber + " не існує"
            );

            return false;
        }

        if (!runway.reserve(flightNumber, operation)) {
            ConsoleLogger.log(
                    "FlightControlCenter",
                    "Відмова: смуга " + runwayNumber
                            + " зайнята рейсом "
                            + runway.getFlightNumber()
            );

            return false;
        }

        ConsoleLogger.log(
                "FlightControlCenter",
                "Дозвіл на " + operation
                        + " для рейсу " + flightNumber
                        + ". Смуга " + runwayNumber + " зарезервована"
        );

        return true;
    }

    public void releaseRunway(int runwayNumber) {
        Runway runway = runways.get(runwayNumber);

        if (runway == null || runway.isFree()) {
            ConsoleLogger.log(
                    "FlightControlCenter",
                    "Неможливо звільнити смугу " + runwayNumber
                            + ": вона вже вільна або не існує"
            );

            return;
        }

        String flightNumber = runway.getFlightNumber();

        runway.release();

        ConsoleLogger.log(
                "FlightControlCenter",
                "Смугу " + runwayNumber
                        + " звільнено після рейсу " + flightNumber
        );
    }
}
