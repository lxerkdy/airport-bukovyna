package bridge;

import java.util.ArrayList;
import java.util.List;

public class DepartureBoard extends FlightBoard {

    public DepartureBoard(DisplayDevice device, List<Flight> flights) {
        super(device, flights);
    }

    @Override
    protected String getTitle() {
        return "Вильоти";
    }

    @Override
    protected List<String> buildLines() {
        List<String> lines = new ArrayList<>();
        for (Flight f : flights) {
            lines.add(f.time() + " | " + f.code() + " | до " + f.city()
                    + " | вихід " + f.gate() + " | " + f.status());
        }
        return lines;
    }
}
