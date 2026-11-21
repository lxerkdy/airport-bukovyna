package flyweight;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import common.ConsoleLogger;

public class SeatTypeFactory {

    public enum SeatTypeType {
        ECONOMY,
        COMFORT,
        BUSINESS
    }

    private final Map<SeatTypeType, SeatType> classes =
            new EnumMap<>(SeatTypeType.class);

    public SeatType getSeatType(SeatTypeType type) {

        SeatType existing = classes.get(type);

        if (existing != null) {
            ConsoleLogger.log(
                    "SeatTypeFactory",
                    "Повторне використання класу " + type
            );

            return existing;
        }

        SeatType created = createSeatType(type);

        classes.put(type, created);

        ConsoleLogger.log(
                "SeatTypeFactory",
                "Створено новий об'єкт класу " + type
        );

        return created;
    }

    private SeatType createSeatType(SeatTypeType type) {

        return switch (type) {

            case ECONOMY -> new SeatType(
                    "Economy",
                    "Стандартний економічний клас",
                    43,
                    79,
                    100,
                    List.of("Багаж", "Освітлення"),
                    "economy.png"
            );

            case COMFORT -> new SeatType(
                    "Comfort",
                    "Покращений економічний клас",
                    48,
                    91,
                    120,
                    List.of("Багаж", "Освітлення", "Більше місця для ніг"),
                    "comfort.png"
            );

            case BUSINESS -> new SeatType(
                    "Business",
                    "Бізнес-клас",
                    55,
                    110,
                    160,
                    List.of(
                            "Багаж",
                            "Освітлення",
                            "Харчування",
                            "Розкладне крісло"
                    ),
                    "business.png"
            );
        };
    }

    public int getCreatedClassesCount() {
        return classes.size();
    }
}