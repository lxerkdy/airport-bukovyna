package abstractfactory;

import common.ConsoleLogger;

public class GroundHandlingDispatcher {

    public void dispatch(String flightNumber, GroundEquipmentFactory factory) {
        GroundEquipment.Kit kit = factory.createKit();

        ConsoleLogger.log("Диспетчерська",
                "Обслуговування рейсу " + flightNumber
                        + " | Клас літака: " + kit.getAircraftType());

        ConsoleLogger.log("Комплект обладнання",
                kit.getStairs().getDescription());

        ConsoleLogger.log("Комплект обладнання",
                kit.getTowTractor().getDescription());

        ConsoleLogger.log("Комплект обладнання",
                kit.getCargoLoader().getDescription());

        ConsoleLogger.log("Диспетчерська",
                "Комплект для рейсу " + flightNumber
                        + " сформовано. Усі одиниці належать до одного сімейства.");
    }
}