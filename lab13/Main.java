import chainofresponsibility.*;
import common.ConsoleLogger;

public class Main {

    private static void processPassenger(Passenger passenger) {
        System.out.println();
        ConsoleLogger.log(
                "Airport",
                "Початок передпольотного контролю"
        );

        ConsoleLogger.log(
                "Airport",
                "Пасажир: " + passenger.getName()
                        + " | Рейс: " + passenger.getFlightNumber()
                        + " | Тип: " + passenger.getFlightType()
        );

        CheckHandler chain =
                PreFlightChainFactory.createChain(passenger.getFlightType());

        chain.handle(passenger);

        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {

        Passenger passenger1 = new Passenger(
                "Олександр",
                "PS-101",
                FlightType.DOMESTIC,
                true,
                true,
                false,
                7.5
        );

        Passenger passenger2 = new Passenger(
                "Марія",
                "PS-202",
                FlightType.INTERNATIONAL,
                true,
                true,
                false,
                6.0
        );

        Passenger passenger3 = new Passenger(
                "Андрій",
                "PS-303",
                FlightType.DOMESTIC,
                false,
                true,
                false,
                5.0
        );

        Passenger passenger4 = new Passenger(
                "Ірина",
                "PS-404",
                FlightType.INTERNATIONAL,
                true,
                false,
                false,
                6.0
        );

        Passenger passenger5 = new Passenger(
                "Дмитро",
                "PS-505",
                FlightType.DOMESTIC,
                true,
                true,
                true,
                5.0
        );

        Passenger passenger6 = new Passenger(
                "Софія",
                "PS-606",
                FlightType.INTERNATIONAL,
                true,
                true,
                false,
                12.0
        );

        processPassenger(passenger1);
        processPassenger(passenger2);
        processPassenger(passenger3);
        processPassenger(passenger4);
        processPassenger(passenger5);
        processPassenger(passenger6);
    }
}