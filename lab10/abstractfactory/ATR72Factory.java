package abstractfactory;

public class ATR72Factory implements GroundEquipmentFactory {

    @Override
    public GroundEquipment.Kit createKit() {
        return new GroundEquipment.Kit(
                "ATR-72",
                new ATR72Stairs(),
                new ATR72TowTractor(),
                new ATR72CargoLoader()
        );
    }

    private static class ATR72Stairs implements GroundEquipment.Stairs {
        @Override
        public String getDescription() {
            return "Пасажирські трапи для ATR-72";
        }
    }

    private static class ATR72TowTractor implements GroundEquipment.TowTractor {
        @Override
        public String getDescription() {
            return "Буксирувальник для ATR-72";
        }
    }

    private static class ATR72CargoLoader implements GroundEquipment.CargoLoader {
        @Override
        public String getDescription() {
            return "Вантажний навантажувач для ATR-72";
        }
    }
}