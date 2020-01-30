package Matrix;

public class Matrix implements BrilliantMatrix {
    private double[][] elements;
    private Size size;

    public Matrix(Size size) {
        this.size = new Size(size.getRow(), size.getColumn());
        elements = new double[this.size.getRow()][this.size.getColumn()];
    }

    public Matrix(double[][] elements) {
        if (elements == null) {
            this.elements = new double[1][1];
            this.size = new Size(1, 1);
            return;
        }
        this.size = new Size(elements.length, elements[0].length);
        this.elements = elements.clone();
    }

    @Override
    public Size getSize() {
        return size.clone();
    }

    @Override
    public double getElement(Position position) {
        if (position.entrySize(size)) {
            return elements[position.getRow()][position.getColumn()];
        } else {
            assert false : "Wrong position. getElement";
            return 0;
        }
    }

    @Override
    public void setElement(Position position, double element) {
        if (position.entrySize(size)) {
            elements[position.getRow()][position.getColumn()] = element;
        } else {
            assert false : "Wrong position. setElement";
        }
    }

    @Override
    public boolean equals(Object compareMatrix) {
        Matrix compare = (Matrix) compareMatrix;
        if (compare == null) {
            return false;
        }
        if (elements == null && compare.elements == null) {
            return true;
        }
        if (elements == null || compare.elements == null) {
            return false;
        }
        if (!size.equals(compare.size)) {
            return false;
        }
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[i].length; j++) {
                if (getElement(new Position(i, j)) != compare.getElement(new Position(i, j))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public Matrix perform(Matrix other, OperationMatrix operationMatrix) {
        if (other == null) {
            assert false : "perform. Matrix other = null";
            return null;
        }
        if (other.elements == null) {
            assert false : "perform. Matrix other.elements = null";
            return null;
        }
        if (!size.equals(other.getSize())) {
            return new Matrix(new Size());
        }
        Matrix add = new Matrix(size);
        double sum;
        for (int i = 0; i < size.getRow(); i++) {
            for (int j = 0; j < size.getColumn(); j++) {
                sum = operationMatrix.calculation(getElement(new Position(i, j)), other.getElement(new Position(i, j)));
                add.setElement(new Position(i, j), sum);
            }
        }
        return add;
    }


    @Override
    public double[] getRow(int rowIndex) {
        if (!(new Position(rowIndex, 0).entrySize(size))) {
            assert false : "Wrong rowIndex";
        }
        return elements[rowIndex].clone();
    }

    @Override
    public double[] getColumn(int columnIndex) {
        if (!(new Position(0, columnIndex).entrySize(size))) {
            assert false : "Wrong columnIndex";
        }
        double[] columnToMas = new double[size.getRow()];
        for (int i = 0; i < elements.length; i++) {
            columnToMas[i] = elements[i][columnIndex];
        }
        return columnToMas;
    }

    private double mulRowColumn(double[] row, double[] column) {
        double sum = 0;
        for (int i = 0; i < row.length; i++) {
            sum += row[i] * column[i];
        }
        return sum;
    }

    @Override
    public Matrix multi(Matrix other) {
        if (other == null) {
            assert false : "perform. Matrix other = null";
            return null;
        }
        if (elements == null || other.elements == null) {
            assert false : "perform. Matrix other.elements = null";
            return null;
        }
        if (size.getColumn() != other.size.getRow()) {
            return new Matrix(new Size());
        }
        Matrix mul = new Matrix(new Size(size.getColumn(), other.size.getColumn()));
        for (int i = 0; i < size.getRow(); i++) {
            for (int j = 0; j < other.size.getColumn(); j++) {
                double sum = mulRowColumn(this.elements[i], other.getColumn(j));
                mul.setElement(new Position(i, j), sum);
            }
        }
        return mul;
    }

    private void changeRows(double[][] Mat, int i, int line) {
        double cur;
        for (int p = i + 1; p < line; p++) {
            if (Mat[p][i] != 0) {
                for (int j = i; j < line; j++) {
                    cur = Mat[i][j];
                    Mat[i][j] = Mat[p][j];
                    Mat[p][j] = -cur;
                }
                break;
            }
        }
    }

    private Matrix toTriangularMatrix() {
        if (!size.checkSquare()) {
            assert false : "toTriangularMatrix Matrix no square";
            return new Matrix(new Size());
        }
        double[][] triangular = elements.clone();
        double cur;
        for (int i = 0; i < size.getRow(); i++) {
            if (triangular[i][i] == 0) {
                changeRows(triangular, i, size.getRow());
            }
            for (int k = i + 1; k < size.getRow(); k++) {
                if (triangular[i][i] == 0) {
                    break;
                }
                cur = triangular[k][i] / triangular[i][i];
                for (int j = i; j < size.getColumn(); j++) {
                    triangular[k][j] = triangular[k][j] - cur * triangular[i][j];
                }
            }
        }
        return new Matrix(triangular);
    }

    @Override
    public double calcDeterminate() {
        if (!size.checkSquare()) {
            assert false : "calcDeterminate Matrix no square";
            return 0;
        }
        double det = 1;
        Matrix triangular = this.toTriangularMatrix();
        for (int i = 0; i < triangular.size.getRow(); i++) {
            det *= triangular.getElement(new Position(i, i));
        }
        return det;
    }

    @Override
    public String toString() {
        String result = "{";
        for (double[] element : elements) {
            result += "{";
            for (int columns = 0; columns < elements[0].length; columns++) {
                result += element[columns] + " ";
            }
            result += "}\n";
        }
        result += "}";
        return result;
    }

    @Override
    public Matrix clone() {
        Matrix clone = new Matrix(size);
        for (int row = 0; row < size.getRow(); row++) {
            for (int column = 0; column < size.getColumn(); column++) {
                clone.setElement(new Position(row, column), this.getElement(new Position(row, column)));
            }
        }
        return clone;
    }
}

