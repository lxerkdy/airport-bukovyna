package composite;

import java.util.ArrayList;
import java.util.List;

import common.ConsoleLogger;

public class CargoGroup implements Cargo {

    private final String name;
    private final List<Cargo> children = new ArrayList<>();

    public CargoGroup(String name) {
        this.name = name;
    }

    public void add(Cargo cargo) {
        children.add(cargo);
    }

    public void remove(Cargo cargo) {
        children.remove(cargo);
    }

    @Override
    public double getWeight() {
        double totalWeight = 0;

        for (Cargo cargo : children) {
            totalWeight += cargo.getWeight();
        }

        return totalWeight;
    }

    @Override
    public int getPieceCount() {
        int totalPieces = 0;

        for (Cargo cargo : children) {
            totalPieces += cargo.getPieceCount();
        }

        return totalPieces;
    }

    @Override
    public void printTree(String indent) {
        ConsoleLogger.log(
                "CargoGroup",
                indent + name
                        + " | вага: " + getWeight() + " кг"
                        + " | місць: " + getPieceCount()
        );

        for (Cargo cargo : children) {
            cargo.printTree(indent + "    ");
        }
    }
}