package bridge;

import java.util.List;

import common.ConsoleLogger;

public class LcdScreen implements DisplayDevice {

    @Override
    public String getName() {
        return "LCD-екран";
    }

    @Override
    public void render(String title, List<String> lines) {
        ConsoleLogger.log("LcdScreen", "┌── " + title + " ──┐");
        for (String line : lines) {
            ConsoleLogger.log("LcdScreen", "│ " + line);
        }
        ConsoleLogger.log("LcdScreen", "└──────────────┘");
    }
}
