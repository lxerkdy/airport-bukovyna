package flyweight;

import common.ConsoleLogger;

public class Seat {

    private final int row;
    private final char letter;
    private final String passengerName;

    private final SeatType SeatType;

    public Seat(
            int row,
            char letter,
            String passengerName,
            SeatType SeatType
    ) {
        this.row = row;
        this.letter = letter;
        this.passengerName = passengerName;
        this.SeatType = SeatType;
    }

    public int getRow() {
        return row;
    }

    public char getLetter() {
        return letter;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public SeatType getSeatType() {
        return SeatType;
    }

    public void printDetails(String flightNumber) {

        ConsoleLogger.log(
                "Seat",
                "Рейс: " + flightNumber
                        + " | місце: " + row + letter
                        + " | пасажир: " + passengerName
                        + " | клас: " + SeatType.getName()
        );

        SeatType.printDetails();
    }
}