package chainofresponsibility;

public class PassportControlCheck extends CheckHandler {

    @Override
    protected String check(Passenger passenger) {
        if (!passenger.hasValidPassport()) {
            return "паспорт недійсний або термін його дії закінчився.";
        }

        return null;
    }
}