package facade;

import common.ConsoleLogger;

public class PassengerRegistrationFacade {

    private final DocumentChecker documentChecker = new DocumentChecker();
    private final CabinPlacementService cabinPlacementService =
            new CabinPlacementService();
    private final BaggageAcceptanceService baggageAcceptanceService =
            new BaggageAcceptanceService();
    private final BoardingPassPrinter boardingPassPrinter =
            new BoardingPassPrinter();
    private final BorderServiceNotifier borderServiceNotifier =
            new BorderServiceNotifier();

    public boolean registerPassenger(String passengerName, String documentNumber,
                                     String flightNumber, String seatNumber,
                                     double baggageWeight) {
        ConsoleLogger.log("PassengerRegistrationFacade",
                "Початок реєстрації пасажира " + passengerName);
        if (!documentChecker.checkDocuments(passengerName, documentNumber)) {
            ConsoleLogger.log("PassengerRegistrationFacade",
                    "Реєстрацію скасовано: документи не пройшли перевірку");
            return false;
        }
        if (!cabinPlacementService.assignSeat(passengerName, flightNumber,
                seatNumber)) {
            ConsoleLogger.log("PassengerRegistrationFacade",
                    "Реєстрацію скасовано: місце недоступне");
            return false;
        }
        baggageAcceptanceService.acceptBaggage(passengerName, baggageWeight);
        boardingPassPrinter.printBoardingPass(passengerName, flightNumber, seatNumber);
        borderServiceNotifier.notifyRegistration(passengerName, flightNumber);
        ConsoleLogger.log("PassengerRegistrationFacade",
                "Реєстрацію пасажира завершено успішно");
        return true;
    }

    public void reprintBoardingPass(String passengerName, String flightNumber,
                                   String seatNumber) {
        ConsoleLogger.log("PassengerRegistrationFacade",
                "Повторний друк посадкового талона");
        boardingPassPrinter.printBoardingPass(passengerName, flightNumber, seatNumber);
    }
}
