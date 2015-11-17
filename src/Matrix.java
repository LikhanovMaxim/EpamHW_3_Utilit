public class Matrix {
    private double[][] matrix;
    private int rows;
    private int column;

    Matrix(int rows, int column) {
        this.rows = rows;
        this.column = column;
        matrix = new double[rows][column];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    Matrix(double[][] mat, int rows, int column) {
        this.rows = rows;
        this.column = column;
        matrix = new double[rows][column];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = mat[i][j];
            }
        }
    }
    
    public void print() {
        if (matrix == null) {
            System.out.println("Matrix = null");
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public double getElem(int i, int j) {
        if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
            return matrix[i][j];
        } else {
            System.out.println("wrong index");
            return 0;
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumn() {
        return column;
    }

    public boolean equally(double[][] firstMatrix, double[][] secondMatrix) {
        if (firstMatrix == null && secondMatrix == null) {
            return true;
        }
        if (firstMatrix == null || secondMatrix == null) {
            return false;
        }
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        if (firstMatrix == null || secondMatrix == null) {
            return false;
        }
        boolean flag;
        flag = true;
        for (int i = 0; i < firstMatrix.length && flag; i++) {
            if (firstMatrix[i].length != secondMatrix[i].length) {
                flag = false;
                break;
            }
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j]) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public boolean setElem(int rows, int column, double element) {
        if (rows >= 0 && this.rows < rows && column >= 0 && column < this.column) {
            matrix[rows][column] = element;
            return true;
        } else {
            return false;
        }
    }

    public Matrix multipl(Matrix secondMatrix) {
        if (matrix == null || secondMatrix == null) {
            return null;
        }
        if (this.rows != secondMatrix.getRows()) {
            return null;
        }
        int sum;
        double[][] mulMatrix;
        mulMatrix = new double[column][secondMatrix.getColumn()];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < secondMatrix.getColumn(); j++) {
                sum = 0;
                for (int r = 0; r < secondMatrix.getRows(); r++) {
                    sum += matrix[i][r] * secondMatrix.getElem(r, j);
                }
                mulMatrix[i][j] = sum;
            }
        }
        Matrix res = new Matrix(mulMatrix, column, secondMatrix.getColumn());
        return res;
    }

    public Matrix addM(Matrix secondMatrix) {
        if (matrix == null || secondMatrix == null) {
            return null;
        }
        if (rows != secondMatrix.getRows() || column != secondMatrix.getColumn()) {
            return null;
        }
        double[][] addMatrix;
        addMatrix = new double[rows][column];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                addMatrix[i][j] = matrix[i][j] + secondMatrix.getElem(i, j);
            }
        }
        Matrix res = new Matrix(addMatrix, rows, column);
        return res;
    }

    public Matrix sub(Matrix secondMatrix) {
        if (matrix == null || secondMatrix == null) {
            return null;
        }
        if (rows != secondMatrix.getRows() || column != secondMatrix.getColumn()) {
            return null;
        }
        double[][] subMatrix;
        subMatrix = new double[rows][column];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                subMatrix[i][j] = matrix[i][j] - secondMatrix.getElem(i, j);
            }
        }
        Matrix res = new Matrix(subMatrix, rows, column);
        return res;
    }

    public double[][] transfMatToDoubl() {
        double[][] transfDoubl = new double[rows][column];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                transfDoubl[i][j] = matrix[i][j];
            }
        }
        return transfDoubl;
    }

    public static void changeRows(double[][] Mat, int i, int line) {
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
        double[][] triangMat = this.transfMatToDoubl();
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
        Matrix res = new Matrix(triangMat, rows, column);
        return res;
    }

    public double determin() {
        if (matrix == null || rows != column) {
            return 0;
        }
        double det = 1;
        Matrix triangMat = this.transfTriangMat();
        for (int i = 0; i < triangMat.getRows(); i++) {
            det *= triangMat.getElem(i, i);
        }
        return det;
    }
}
