
package common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLogger {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    public static void log(String source, String event) {
        String time = LocalDateTime.now().format(FORMATTER);

        System.out.printf(
                "[%s] [%s] %s%n",
                time,
                source,
                event
        );
    }
}
