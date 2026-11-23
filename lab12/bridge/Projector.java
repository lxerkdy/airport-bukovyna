package bridge;

import java.util.List;

import common.ConsoleLogger;

/**
 * Нове обладнання: додається одним класом, без змін у видах табло.
 */
public class Projector implements DisplayDevice {

    @Override
    public String getName() {
        return "Проектор";
    }

    @Override
    public void render(String title, List<String> lines) {
        ConsoleLogger.log("Projector", "[Проєкція на стіну] " + title);
        for (String line : lines) {
            ConsoleLogger.log("Projector", "~ " + line);
        }
    }
}
