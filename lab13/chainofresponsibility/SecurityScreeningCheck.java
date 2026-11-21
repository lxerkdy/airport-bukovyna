package chainofresponsibility;

public class SecurityScreeningCheck extends CheckHandler {

    @Override
    protected String check(Passenger passenger) {
        if (passenger.hasProhibitedItems()) {
            return "виявлено заборонені предмети в ручній поклажі.";
        }

        return null;
    }
}