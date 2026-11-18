package facade;

import common.ConsoleLogger;

public class BoardingPassPrinter {

    public void printBoardingPass(String passengerName, String flightNumber,
                                  String seatNumber) {
        ConsoleLogger.log("BoardingPassPrinter",
                "Надруковано посадковий талон: " + passengerName
                        + ", рейс " + flightNumber + ", місце " + seatNumber);
    }
}
