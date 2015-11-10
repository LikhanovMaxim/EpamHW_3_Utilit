public class Matrix {
    private int line;
    private int column;
    private double[][] matrix;

    Matrix() {
        line = 10;
        column = 10;
        matrix = new double[line][column];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    Matrix(double[][] mat, int n, int m) {
        line = n;
        column = m;
        matrix = new double[line][column];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = mat[i][j];
            }
        }
    }

    Matrix(Matrix mat) {
        line = mat.getLine();
        column = mat.getColumn();
        matrix = new double[line][column];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = mat.getElemMatr(i, j);
            }
        }
    }

    public void printMatrix() {
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

    public double getElemMatr(int i, int j) {
        if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
            return matrix[i][j];
        } else {
            System.out.println("wrong index");
            return 0;
        }
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public boolean equallyMatix(double[][] firstMatrix, double[][] secondMatrix) {
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

    public boolean setElemMatr(int i, int j, double element) {
        if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
            matrix[i][j] = element;
            return true;
        } else {
            return false;
        }
    }

    public Matrix multiplMatrix(Matrix secondMatrix) {
        if (matrix == null || secondMatrix == null) {
            return null;
        }
        if (matrix[0].length != secondMatrix.getLine()) {
            return null;
        }
        int sum;
        double[][] mulMatrix;
        mulMatrix = new double[column][secondMatrix.getColumn()];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < secondMatrix.getColumn(); j++) {
                sum = 0;
                for (int r = 0; r < secondMatrix.getLine(); r++) {
                    sum += matrix[i][r] * secondMatrix.getElemMatr(r, j);
                }
                mulMatrix[i][j] = sum;
            }
        }
        Matrix res = new Matrix(mulMatrix, column, secondMatrix.getColumn());
        return res;
    }

    public Matrix addMatrix(Matrix secondMatrix) {
        if (matrix == null || secondMatrix == null) {
            return null;
        }
        if (line != secondMatrix.getLine() || column != secondMatrix.getColumn()) {
            return null;
        }
        double[][] addMatrix;
        addMatrix = new double[line][column];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                addMatrix[i][j] = matrix[i][j] + secondMatrix.getElemMatr(i, j);
            }
        }
        Matrix res = new Matrix(addMatrix, line, column);
        return res;
    }

    public Matrix subMatrix(Matrix secondMatrix) {
        if (matrix == null || secondMatrix == null) {
            return null;
        }
        if (line != secondMatrix.getLine() || column != secondMatrix.getColumn()) {
            return null;
        }
        double[][] subMatrix;
        subMatrix = new double[line][column];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                subMatrix[i][j] = matrix[i][j] - secondMatrix.getElemMatr(i, j);
            }
        }
        Matrix res = new Matrix(subMatrix, line, column);
        return res;
    }

    public double[][] transfMatToDoubl() {
        double[][] transfDoubl = new double[line][column];
        for (int i = 0; i < line; i++) {
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
        if (matrix == null || line != column) {
            return null;
        }
        double[][] triangMat = this.transfMatToDoubl();
        double cur;
        for (int i = 0; i < line; i++) {
            if (triangMat[i][i] == 0) {
                changeRows(triangMat, i, line);
            }
            for (int k = i + 1; k < line; k++) {
                if (triangMat[i][i] == 0) {
                    break;
                }
                cur = triangMat[k][i] / triangMat[i][i];
                for (int j = i; j < column; j++) {
                    triangMat[k][j] = triangMat[k][j] - cur * triangMat[i][j];
                }
            }
        }
        Matrix res = new Matrix(triangMat, line, column);
        return res;
    }

    public double determinMat() {
        if (matrix == null || line != column) {
            return 0;
        }
        double det = 1;
        Matrix triangMat = this.transfTriangMat();
        for (int i = 0; i < triangMat.getLine(); i++) {
            det *= triangMat.getElemMatr(i, i);
        }
        return det;
    }
}
