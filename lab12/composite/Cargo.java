package composite;

public interface Cargo {
    double getWeight();

    int getPieceCount();

    void printTree(String indent);
}