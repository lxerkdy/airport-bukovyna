package chainofresponsibility;

public class PreFlightChainFactory {

    public static CheckHandler createChain(FlightType flightType) {
        CheckHandler boardingPass = new BoardingPassCheck();
        CheckHandler security = new SecurityScreeningCheck();
        CheckHandler luggage = new HandLuggageWeightCheck();

        if (flightType == FlightType.INTERNATIONAL) {
            CheckHandler passport = new PassportControlCheck();

            boardingPass.setNext(passport);
            passport.setNext(security);
        } else {
            boardingPass.setNext(security);
        }

        if (flightType == FlightType.INTERNATIONAL) {
            security.setNext(luggage);
        } else {
            security.setNext(luggage);
        }

        return boardingPass;
    }
}