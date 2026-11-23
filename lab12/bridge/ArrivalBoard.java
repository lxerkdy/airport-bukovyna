package bridge;

import java.util.ArrayList;
import java.util.List;

public class ArrivalBoard extends FlightBoard {

    public ArrivalBoard(DisplayDevice device, List<Flight> flights) {
        super(device, flights);
    }

    @Override
    protected String getTitle() {
        return "Прильоти";
    }

    @Override
    protected List<String> buildLines() {
        List<String> lines = new ArrayList<>();
        for (Flight f : flights) {
            lines.add(f.time() + " | " + f.code() + " | з " + f.city()
                    + " | " + f.status());
        }
        return lines;
    }
}
