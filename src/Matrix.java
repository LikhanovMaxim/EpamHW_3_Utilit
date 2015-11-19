public class Matrix {
    private double[][] matrix;
    private int rows;
    private int column;

//    static void printMatrix(double[][] Matrix) {
//        if (Matrix == null) {
//            System.out.println("Matrix = null");
//            return;
//        }
//        for (int rows = 0; rows < Matrix.length; rows++) {
//            for (int columns = 0; columns < Matrix[0].length; columns++) {
//                System.out.print(Matrix[rows][columns] + " ");
//            }
//            System.out.println();
//        }
//    }
//
    public void print() {
        if (matrix == null) {
            System.out.println("Matrix = null");
            return;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    Matrix(int rows, int column) {
        if (rows < 0 || column < 0) {
            this.rows = 0;
            this.column = 0;
            matrix = null;
            return;
        }
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


    public double getElem(int i, int j) {
        if (i >= 0 && i < rows && j >= 0 && j < column) {
            return matrix[i][j];
        } else {
            return 0;
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumn() {
        return column;
    }

    public boolean equals(double[][] compareMatrix) {
        if (matrix == null && compareMatrix == null) {
            return true;
        }
        if (matrix == null || compareMatrix == null) {
            return false;
        }
        if (matrix.length != compareMatrix.length) {
            return false;
        }
        if (matrix == null || compareMatrix == null) {
            return false;
        }
        boolean flag = true;
        for (int i = 0; i < matrix.length && flag; i++) {
            if (matrix[i].length != compareMatrix[i].length) {
                flag = false;
                break;
            }
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != compareMatrix[i][j]) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public boolean equals(Matrix compareMatrix) {
        if (compareMatrix == null) {
            return false;
        }
        if (matrix == null && compareMatrix.matrix == null) {
            return true;
        }
        if (matrix == null || compareMatrix.matrix == null) {
            return false;
        }
        if (matrix.length != compareMatrix.getRows()) {
            return false;
        }
        if (matrix == null || compareMatrix == null) {
            return false;
        }
        boolean flag = true;
        for (int i = 0; i < matrix.length && flag; i++) {
            if (matrix[i].length != compareMatrix.matrix[i].length) {
                flag = false;
                break;
            }
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != compareMatrix.getElem(i, j)) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
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
        if (column != cofactor.getRows()) {
            return null;
        }
        double[][] mulMatrix = new double[column][cofactor.getColumn()];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cofactor.getColumn(); j++) {
                double sum = mulRowColumn(this.matrix[i], getColumn(cofactor.matrix, j));
                mulMatrix[i][j] = sum;
            }
        }
        Matrix res = new Matrix(mulMatrix, column, cofactor.getColumn());
        return res;
    }

    public Matrix add(Matrix addend) {
        if (addend == null) {
            return null;
        }
        if (matrix == null || addend.matrix == null) {
            return null;
        }
        if (rows != addend.getRows() || column != addend.getColumn()) {
            return null;
        }
        double[][] addMatrix;
        addMatrix = new double[rows][column];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                addMatrix[i][j] = matrix[i][j] + addend.getElem(i, j);
            }
        }
        Matrix res = new Matrix(addMatrix, rows, column);
        return res;
    }

    public Matrix sub(Matrix subtrahend) {
        if (subtrahend == null) {
            return null;
        }
        if (matrix == null || subtrahend.matrix == null) {
            return null;
        }
        if (rows != subtrahend.getRows() || column != subtrahend.getColumn()) {
            return null;
        }
        double[][] subMatrix;
        subMatrix = new double[rows][column];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                subMatrix[i][j] = matrix[i][j] - subtrahend.getElem(i, j);
            }
        }
        Matrix res = new Matrix(subMatrix, rows, column);
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
    @Override
    public Matrix clone() throws CloneNotSupportedException {
        Matrix cloneMat=new Matrix(this.matrix, this.getRows(), this.column);
        return cloneMat;
    }
    //    public double[][] transfMatToDoubl() {
//        double[][] transfDoubl = new double[rows][column];
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < column; j++) {
//                transfDoubl[i][j] = matrix[i][j];
//            }
//        }
//        return transfDoubl;
//    }
}

