package abstractfactory;

public class WideBodyFactory implements GroundEquipmentFactory {

    @Override
    public GroundEquipment.Kit createKit() {
        return new GroundEquipment.Kit(
                "Широкофюзеляжний літак",
                new WideBodyStairs(),
                new WideBodyTowTractor(),
                new WideBodyCargoLoader()
        );
    }

    private static class WideBodyStairs implements GroundEquipment.Stairs {
        @Override
        public String getDescription() {
            return "Пасажирські трапи для широкофюзеляжного літака";
        }
    }

    private static class WideBodyTowTractor implements GroundEquipment.TowTractor {
        @Override
        public String getDescription() {
            return "Потужний буксирувальник для широкофюзеляжного літака";
        }
    }

    private static class WideBodyCargoLoader implements GroundEquipment.CargoLoader {
        @Override
        public String getDescription() {
            return "Вантажний навантажувач для широкофюзеляжного літака";
        }
    }
}