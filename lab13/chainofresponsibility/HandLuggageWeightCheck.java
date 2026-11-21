package chainofresponsibility;

public class HandLuggageWeightCheck extends CheckHandler {
    private static final double MAX_WEIGHT = 8.0;

    @Override
    protected String check(Passenger passenger) {
        if (passenger.getHandLuggageWeight() > MAX_WEIGHT) {
            return "вага ручної поклажі становить "
                    + passenger.getHandLuggageWeight()
                    + " кг, допустима вага — "
                    + MAX_WEIGHT + " кг.";
        }

        if (passenger.getHandLuggageWeight() < 0) {
            return "вага ручної поклажі не може бути від'ємною.";
        }

        return null;
    }
}