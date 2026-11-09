package abstractfactory;

public final class GroundEquipment {

    private GroundEquipment() {}

    public interface Stairs {
        String getDescription();
    }

    public interface TowTractor {
        String getDescription();
    }

    public interface CargoLoader {
        String getDescription();
    }

    public static class Kit {
        private final String aircraftType;
        private final Stairs stairs;
        private final TowTractor towTractor;
        private final CargoLoader cargoLoader;

        Kit(
                String aircraftType,
                Stairs stairs,
                TowTractor towTractor,
                CargoLoader cargoLoader
        ) {
            this.aircraftType = aircraftType;
            this.stairs = stairs;
            this.towTractor = towTractor;
            this.cargoLoader = cargoLoader;
        }

        public String getAircraftType() {
            return aircraftType;
        }

        public Stairs getStairs() {
            return stairs;
        }

        public TowTractor getTowTractor() {
            return towTractor;
        }

        public CargoLoader getCargoLoader() {
            return cargoLoader;
        }
    }
}