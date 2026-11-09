package abstractfactory;

public class AirbusA320Factory implements GroundEquipmentFactory {

    @Override
    public GroundEquipment.Kit createKit() {
        return new GroundEquipment.Kit(
                "Airbus A320",
                new A320Stairs(),
                new A320TowTractor(),
                new A320CargoLoader()
        );
    }

    private static class A320Stairs implements GroundEquipment.Stairs {
        @Override
        public String getDescription() {
            return "Пасажирські трапи для Airbus A320";
        }
    }

    private static class A320TowTractor implements GroundEquipment.TowTractor {
        @Override
        public String getDescription() {
            return "Буксирувальник для Airbus A320";
        }
    }

    private static class A320CargoLoader implements GroundEquipment.CargoLoader {
        @Override
        public String getDescription() {
            return "Вантажний навантажувач для Airbus A320";
        }
    }
}