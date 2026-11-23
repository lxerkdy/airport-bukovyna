package bridge;

import java.util.List;

import common.ConsoleLogger;

public class LedPanel implements DisplayDevice {

    @Override
    public String getName() {
        return "LED-панель";
    }

    @Override
    public void render(String title, List<String> lines) {
        ConsoleLogger.log("LedPanel", "*** " + title.toUpperCase() + " ***");
        for (String line : lines) {
            ConsoleLogger.log("LedPanel", "* " + line.toUpperCase());
        }
    }
}
