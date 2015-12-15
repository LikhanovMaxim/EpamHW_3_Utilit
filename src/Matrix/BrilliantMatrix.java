package Matrix;

public interface BrilliantMatrix {
    Size getSize();

    double getElement(Position position);

    boolean equals(Object compareMatrix);

    void setElement(Position position, double element);

    Matrix perform(Matrix other, OperationMatrix operationMatrix);

    double[] getRow(int rowIndex);

    double[] getColumn(int columnIndex);

    Matrix multi(Matrix other);

    double calcDeterminate();
}
