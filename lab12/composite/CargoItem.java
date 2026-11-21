package composite;

import common.ConsoleLogger;

public class CargoItem implements Cargo {

    private final String name;
    private final double weight;

    public CargoItem(String name, double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException(
                    "Вага не може бути від'ємною"
            );
        }

        this.name = name;
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int getPieceCount() {
        return 1;
    }

    @Override
    public void printTree(String indent) {
        ConsoleLogger.log(
                "CargoItem",
                indent + name
                        + " | вага: " + weight + " кг"
                        + " | місць: 1"
        );
    }
}