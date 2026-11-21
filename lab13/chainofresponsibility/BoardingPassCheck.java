package chainofresponsibility;

public class BoardingPassCheck extends CheckHandler {

    @Override
    protected String check(Passenger passenger) {
        if (!passenger.hasValidBoardingPass()) {
            return "посадковий талон недійсний.";
        }

        if (passenger.getFlightNumber() == null
                || passenger.getFlightNumber().isBlank()) {
            return "номер рейсу відсутній.";
        }

        return null;
    }
}