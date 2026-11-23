package bridge;

import java.util.ArrayList;
import java.util.List;

public class GateBoard extends FlightBoard {

    public GateBoard(DisplayDevice device, List<Flight> flights) {
        super(device, flights);
    }

    @Override
    protected String getTitle() {
        return "Посадка";
    }

    @Override
    protected List<String> buildLines() {
        List<String> lines = new ArrayList<>();
        for (Flight f : flights) {
            lines.add("Вихід " + f.gate() + " | " + f.code() + " до "
                    + f.city() + " | посадка до " + f.time());
        }
        return lines;
    }
}
