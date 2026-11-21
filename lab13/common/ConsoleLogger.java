package common;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLogger {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void log(String source, String message) {
        String time = LocalTime.now().format(FORMATTER);
        System.out.println("[" + time + "] [" + source + "] " + message);
    }
}