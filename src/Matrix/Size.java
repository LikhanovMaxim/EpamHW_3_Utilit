package Matrix;

public class Size {
    private int row;
    private int column;

    Size() {
        row = 1;
        column = 1;
    }

    Size(int row, int column) {
        if (row < 1 || column < 1) {
            this.row = 1;
            this.column = 1;
            assert false : "Wrong size matrix";
        } else {
            this.row = row;
            this.column = column;
        }
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean equals(Object compareSize) {
        Size compare = (Size) compareSize;
        if (row == compare.getRow() && column == compare.getColumn()) {
            return true;
        }
        return false;
    }

    public boolean checkSquare() {
        if (row == column) {
            return true;
        }
        return false;
    }

    @Override
    public Size clone() {
        Size clone = new Size(this.row, this.column);
        return clone;
    }
}
