package bridge;

import java.util.List;

import common.ConsoleLogger;

/**
 * Abstraction: визначає, ЩО показується (вид табло).
 * Містить посилання (міст) на обладнання.
 */
public abstract class FlightBoard {

    protected DisplayDevice device;
    protected final List<Flight> flights;

    protected FlightBoard(DisplayDevice device, List<Flight> flights) {
        this.device = device;
        this.flights = List.copyOf(flights);
    }

    public void setDevice(DisplayDevice device) {
        this.device = device;
    }

    public DisplayDevice getDevice() {
        return device;
    }

    protected abstract String getTitle();

    protected abstract List<String> buildLines();

    public void show() {
        ConsoleLogger.log(
                getClass().getSimpleName(),
                "Вивід «" + getTitle() + "» на: " + device.getName()
        );
        device.render(getTitle(), buildLines());
    }
}
