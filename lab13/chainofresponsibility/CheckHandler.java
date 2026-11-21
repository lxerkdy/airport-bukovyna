package chainofresponsibility;

import common.ConsoleLogger;

public abstract class CheckHandler {
    private CheckHandler nextHandler;

    public CheckHandler setNext(CheckHandler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public void handle(Passenger passenger) {
        String error = check(passenger);

        if (error != null) {
            ConsoleLogger.log(
                    getClass().getSimpleName(),
                    "Пасажир " + passenger.getName()
                            + " не пройшов перевірку: " + error
            );

            ConsoleLogger.log(
                    "CheckHandler",
                    "Подальші перевірки зупинено."
            );
            return;
        }

        ConsoleLogger.log(
                getClass().getSimpleName(),
                "Пасажир " + passenger.getName()
                        + " успішно пройшов перевірку."
        );

        if (nextHandler != null) {
            nextHandler.handle(passenger);
        } else {
            ConsoleLogger.log(
                    "CheckHandler",
                    "Усі перевірки пройдено. Пасажир допущений до посадки."
            );
        }
    }

    protected abstract String check(Passenger passenger);
}