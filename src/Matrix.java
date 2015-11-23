public class Matrix {
    private double[][] matrix;
    private int rows;
    private int column;

    public Matrix(int rows, int column) {
        if (rows < 0 || column < 0) { //!!!
            this.rows = 1;
            this.column = 1;
            matrix = new double[1][1];
            return;
        }
        this.rows = rows;
        this.column = column;
        matrix = new double[rows][column];
    }

    public Matrix(double[][] mat) {
        if (mat == null) { //!!!!
            matrix = new double[0][0];
            this.rows = 0;
            this.column = 0;
            return;
        }
        this.rows = mat.length;
        this.column = mat[0].length;
//        matrix=mat.clone();
        matrix = new double[rows][column];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = mat[i][j];
            }
        }
    }


    public double getElement(int rows, int column) {
        if (rows >= 0 && rows < this.rows && column >= 0 && column < this.column) {
            return matrix[rows][column];
        } else {
            return 0;
        }
    }

    public int getRow() {
        return rows;
    }

    public int getColumn() {
        return column;
    }

    public boolean equals(Object compareMatrix) {
        Matrix compare = (Matrix)compareMatrix;
        if (compare == null) {
            return false;
        }
        if (matrix == null && compare.matrix == null) {
            return true;
        }
        if (matrix == null || compare.matrix == null) {
            return false;
        }
        if (matrix.length != compare.getRow()) {
            return false;
        }
        if (matrix == null || compare == null) {
            return false;
        }
        for (int i = 0; i < matrix.length && flag; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != compare.getElement(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean setElem(int rows, int column, double element) {
        if (rows >= 0 && rows < this.rows && column >= 0 && column < this.column) {
            matrix[rows][column] = element;
            return true;
        } else {
            return false;
        }
    }

    public double[] getColumn(double[][] Matrix, int column) {
        double[] columnToMas = new double[Matrix.length];
        for (int i = 0; i < Matrix.length; i++) {
            columnToMas[i] = Matrix[i][column];
        }
        return columnToMas;
    }

    public double mulRowColumn(double[] firstMas, double[] secondMas) {
        double sum = 0;
        for (int i = 0; i < firstMas.length; i++) {
            sum += firstMas[i] * secondMas[i];
        }
        return sum;
    }

    public Matrix multipl(Matrix cofactor) {
        if (cofactor == null) {
            return null;
        }
        if (matrix == null || cofactor.matrix == null) {
            return null;
        }
        if (column != cofactor.getRow()) {
            return null;
        }
        double[][] mulMatrix = new double[column][cofactor.getColumn()];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cofactor.getColumn(); j++) {
                double sum = mulRowColumn(this.matrix[i], getColumn(cofactor.matrix, j));
                mulMatrix[i][j] = sum;
            }
        }
        Matrix res = new Matrix(mulMatrix);
        return res;
    }

    public Matrix add(Matrix addend) {
        if (addend == null) {
            return null;
        }
        if (matrix == null || addend.matrix == null) {
            return null;
        }
        if (rows != addend.getRow() || column != addend.getColumn()) {
            return null;
        }
        double[][] addMatrix;
        addMatrix = new double[rows][column];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                addMatrix[i][j] = matrix[i][j] + addend.getElement(i, j);
            }
        }
        Matrix res = new Matrix(addMatrix);
        return res;
    }

    public Matrix sub(Matrix subtrahend) {
        if (subtrahend == null) {
            return null;
        }
        if (matrix == null || subtrahend.matrix == null) {
            return null;
        }
        if (rows != subtrahend.getRow() || column != subtrahend.getColumn()) {
            return null;
        }
        double[][] subMatrix;
        subMatrix = new double[rows][column];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                subMatrix[i][j] = matrix[i][j] - subtrahend.getElement(i, j);
            }
        }
        Matrix res = new Matrix(subMatrix);
        return res;
    }

    public void changeRows(double[][] Mat, int i, int line) {
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

    public Matrix transfTriangMat() {
        if (matrix == null || rows != column) {
            return null;
        }
        double[][] triangMat = matrix.clone();
        double cur;
        for (int i = 0; i < rows; i++) {
            if (triangMat[i][i] == 0) {
                changeRows(triangMat, i, rows);
            }
            for (int k = i + 1; k < rows; k++) {
                if (triangMat[i][i] == 0) {
                    break;
                }
                cur = triangMat[k][i] / triangMat[i][i];
                for (int j = i; j < column; j++) {
                    triangMat[k][j] = triangMat[k][j] - cur * triangMat[i][j];
                }
            }
        }
        Matrix res = new Matrix(triangMat);
        return res;
    }

    public double determin() {
        if (matrix == null || rows != column) {
            return 0;
        }
        double det = 1;
        Matrix triangMat = this.transfTriangMat();
        for (int i = 0; i < triangMat.getRow(); i++) {
            det *= triangMat.getElement(i, i);
        }
        return det;
    }

    @Override
    public String toString() {
        String result = "{";
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int columns = 0; columns < matrix[0].length; columns++) {
                result += matrix[rows][columns] + " ";
            }
            result += "}\n";
        }
        result += "}";
        return result;
    }
//    @Override
//    public Matrix clone() throws CloneNotSupportedException {
//
//        Matrix cloneMat=new Matrix(this.matrix);
//        return cloneMat;
//    }

}

