package bridge;

import java.util.List;

import common.ConsoleLogger;

public class MobileApp implements DisplayDevice {

    @Override
    public String getName() {
        return "Мобільний застосунок";
    }

    @Override
    public void render(String title, List<String> lines) {
        ConsoleLogger.log("MobileApp", "[Екран застосунку] " + title);
        for (String line : lines) {
            ConsoleLogger.log("MobileApp", "• " + line);
        }
    }
}
