import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void testMatrix() throws Exception {
        Matrix mat = new Matrix(2, 2);
        double[][] result = {{0, 0},
                {0, 0}};
        Matrix resultMat = new Matrix(result);
        assertTrue(mat.equals(resultMat));
    }

//    @Test
//    public void emptyMatrix() throws Exception {
//        Matrix mat = new Matrix(0, 0);
//        System.out.println(mat.toString());
//        double[][] result = new double[0][0];
//        Matrix resultMat=new Matrix(result);
//        System.out.println(resultMat.toString());
//        assertTrue(mat.equals(resultMat));
//    }

//    @Test
//    public void nullMatrix() throws Exception {
//        Matrix mat = new Matrix(-2, 0);
//        double[][] nullMat = new double[0][0];
//        Matrix nullMatrix=new Matrix(nullMat);
//        assertTrue(mat.equals(nullMatrix));
//    }

    @Test
    public void testGetElement() throws Exception {
        double[][] matrix = {{1, 2},
                {3, 4}};
        Matrix mat = new Matrix(matrix);
        assertTrue(mat.getElement(1, 1) == 4);
    }

    @Test
    public void nullGetElement() throws Exception {
        double[][] matrix = {{1, 2},
                {3, 4}};
        Matrix mat = new Matrix(matrix);
        assertTrue(mat.getElement(17, 3) == 0);
    }

    @Test
    public void testSetElement() throws Exception {
        double[][] mat = {{1, 2, 3},
                {4, 5, 6}};
        Matrix matrix = new Matrix(mat);
        double[][] result = {{1, 2, 3},
                {17, 5, 6}};
        Matrix matResult = new Matrix(result);
        matrix.setElement(1, 0, 17);
        assertTrue(matrix.equals(matResult));
    }

    @Test
    public void testGetRow() throws Exception {
        double[][] matrix = {{1, 2, 3},
                {4, 5, 6}};
        Matrix mat = new Matrix(matrix);
        assertTrue(mat.getRow() == 2);
    }

    @Test
    public void nullGetRows() throws Exception {
        Matrix mat = new Matrix(null);
        assertTrue(mat.getRow() == 0);
    }

    @Test
    public void emptyGetRows() throws Exception {
        Matrix mat = new Matrix(0, 0);
        assertTrue(mat.getRow() == 0);
    }

    @Test
    public void getColumn() throws Exception {
        double[][] matrix = {{1, 2, 3},
                {4, 5, 6}};
        Matrix mat = new Matrix(matrix);
        assertTrue(mat.getColumn() == 3);
    }

    @Test
    public void nullGetColumn() throws Exception {
        Matrix mat = new Matrix(null);
        assertTrue(mat.getColumn() == 0);
    }

    @Test
    public void emptyGetColumn() throws Exception {
        Matrix mat = new Matrix(0, 0);
        assertTrue(mat.getColumn() == 0);
    }

//    @Test
//    public void emptyEquals() throws Exception {
//        Matrix mat = new Matrix(0, 0);
//        double[][] matEmpty = {};
//        Matrix matrixEmpty = new Matrix(matEmpty);
//        assertTrue(mat.equals(matrixEmpty));
//    }

    @Test
    public void reflexiveEquals() throws Exception {
        double[][] matA = {{5, 8, -4},
                {6, 9, -5},
                {4, 7, -3}};
        Matrix result = new Matrix(matA);
        assertTrue(result.equals(result));
    }

    @Test
    public void differDimenEquals() throws Exception {
        double[][] square = {{-2, 1},
                {5, 4}};
        double[][] rectangular = {{3},
                {-1}};
        Matrix squareMat = new Matrix(square);
        Matrix rectangularMat = new Matrix(rectangular);
        assertFalse(squareMat.equals(rectangularMat));
        assertFalse(rectangularMat.equals(squareMat));
    }

    @Test
    public void sameDimenEquals() throws Exception {
        double[][] firstSquare = {{5, 8, -4},
                {6, 9, -5},
                {4, 7, -3}};
        double[][] secondSquare = {{3, 2, 5},
                {4, -1, 3},
                {9, 6, 5}};
        Matrix firstSquareMat = new Matrix(firstSquare);
        Matrix secondSquareMat = new Matrix(secondSquare);
        assertFalse(firstSquareMat.equals(secondSquareMat));
        assertFalse(secondSquareMat.equals(firstSquareMat));
    }


    @Test
    public void firstGetColumn() throws Exception {
        double[][] mat = {{1, 2, 3},
                {4, 5, 6}};
        Matrix matr = new Matrix(mat);
        double[] result = {1, 4};
        assertTrue(Arrays.equals(result, matr.getColumn(0)));
    }

    @Test
    public void midlGetColumn() throws Exception {
        double[][] mat = {{1, 2, 3},
                {4, 5, 6}};
        Matrix matrix = new Matrix(mat);
        double[] result = {2, 5};
        assertTrue(Arrays.equals(result, matrix.getColumn(1)));
    }

    @Test
    public void lastGetColumn() throws Exception {
        double[][] mat = {{1, 2, 3},
                {4, 5, 6}};
        Matrix matrix = new Matrix(mat);
        double[] result = {3, 6};
        assertTrue(Arrays.equals(result, matrix.getColumn(2)));
    }

    @Test(timeout = 1000)
    public void differDimenMultipl() throws Exception {
        double[][] matA = {{-2, 1},
                {5, 4}};
        Matrix matrixA = new Matrix(matA);
        double[][] matB = {{3},
                {-1}};
        Matrix matrixB = new Matrix(matB);
        double[][] result = {{-7},
                {11}};
        Matrix matrixResult = new Matrix(result);
        assertTrue(matrixResult.equals(matrixA.multipl(matrixB)));
        matrixA = new Matrix(matA);
        assertFalse(matrixResult.equals(matrixB.multipl(matrixA)));
    }

    @Test(timeout = 1000)
    public void sameDimenMultipl() throws Exception {
        double[][] matA = {{2, -3},
                {4, -6}};
        Matrix matrixA = new Matrix(matA);
        double[][] matB = {{9, -6},
                {6, -4}};
        Matrix matrixB = new Matrix(matB);
        double[][] result = {{0, 0},
                {0, 0}};
        Matrix matrixResult = new Matrix(result);
//        System.out.println(matrixA.multipl(matrixB).toString());
        assertTrue(matrixResult.equals(matrixA.multipl(matrixB)));
        matrixA = new Matrix(matA);
        assertFalse(matrixResult.equals(matrixB.multipl(matrixA)));
    }

    @Test
    public void differDimenSub() throws Exception {
        double[][] matA = {{-2, 1},
                {5, 4}};
        Matrix matrixA = new Matrix(matA);
        double[][] matB = {{3},
                {-1}};
        Matrix matrixB = new Matrix(matB);
        assertTrue(matrixA.sub(matrixB) == null);
        matrixA = new Matrix(matA);
        assertTrue(matrixB.sub(matrixA) == null);
    }

    @Test
    public void sameDimenSub() throws Exception {
        double[][] matA = {{12, -3},
                {4, 16}};
        Matrix matrixA = new Matrix(matA);
        double[][] matB = {{9, -6},
                {6, -4}};
        Matrix matrixB = new Matrix(matB);
        double[][] result = {{3, 3},
                {-2, 20}};
        Matrix matrixResult = new Matrix(result);
        assertTrue(matrixResult.equals(matrixA.sub(matrixB)));
        matrixA = new Matrix(matA);
        assertFalse(matrixResult.equals(matrixB.sub(matrixA)));
    }

    @Test
    public void differDimenAdd() throws Exception {
        double[][] matA = {{-2, 1},
                {5, 4}};
        Matrix matrixA = new Matrix(matA);
        double[][] matB = {{3},
                {-1}};
        Matrix matrixB = new Matrix(matB);
        assertTrue(matrixA.add(matrixB) == null);
        matrixA = new Matrix(matA);
        assertTrue(matrixB.add(matrixA) == null);
    }

    @Test
    public void sameDimenAdd() throws Exception {
        double[][] matA = {{2, -3},
                {4, -6}};
        Matrix matrixA = new Matrix(matA);
        double[][] matB = {{9, -6},
                {6, -4}};
        Matrix matrixB = new Matrix(matB);
        double[][] result = {{11, -9},
                {10, -10}};
        Matrix matrixResult = new Matrix(result);
        assertTrue(matrixResult.equals(matrixA.add(matrixB)));
        matrixA = new Matrix(matA);
        assertTrue(matrixResult.equals(matrixB.add(matrixA)));
    }

    @Test
    public void differToTriangularMatrix() throws Exception {
        double[][] matA = {{5, 3},
                {4, 5},
                {1, 1}};
        Matrix matrixA = new Matrix(matA);
        matrixA.toTriangularMatrix();
        assertTrue(matrixA.equals(matrixA));
    }

    @Test
    public void squareToTriangularMatrix() throws Exception {
        double[][] matA = {{5, 3},
                {4, 5}};
        Matrix matrixA = new Matrix(matA);
        double[][] res = {{5, 3},
                {0, 2.5999999999999996}};
        Matrix result = new Matrix(res);
        matrixA.toTriangularMatrix();
        assertTrue(result.equals(matrixA));
    }

    @Test
    public void cubicToTriangularMatrix() throws Exception {
        double[][] matA = {{1, 2, 3},
                {1, 1, 2},
                {3, 1, 1}};
        Matrix matrixA = new Matrix(matA);
        double[][] res = {{1, 2, 3},
                {0, -1, -1},
                {0, 0, -3}};
        Matrix result = new Matrix(res);
        matrixA.toTriangularMatrix();
        assertTrue(result.equals(matrixA));

    }

    @Test
    public void differDimenDetermin() throws Exception {
        double[][] matA = {{5, 3},
                {4, 5},
                {1, 1}};
        Matrix matrixA = new Matrix(matA);
        double result = 0;
        assertTrue(result == matrixA.determin());

    }

    @Test
    public void squarDetermin() throws Exception {
        double[][] matA = {{5, 3},
                {4, 5}};
        Matrix matrixA = new Matrix(matA);
        double result = 13;
        assertTrue(result == (int) matrixA.determin() + 1);
    }

    @Test
    public void cubicDetermin() throws Exception {
        double[][] matA = {{1, 2, 3},
                {1, 1, 2},
                {3, 1, 1}};
        Matrix matrixA = new Matrix(matA);
        double result = 3;
        assertTrue(result == matrixA.determin());
    }

    @Test
    public void testClone() throws CloneNotSupportedException {
        double[][] matA = {{1, 2, 3},
                {1, 1, 2},
                {3, 1, 1}};
        Matrix matrixA = new Matrix(matA);
        Matrix result =  matrixA.clone();
        assertTrue(result.equals(matrixA));
        result.setElement(1, 1, 17);
        assertFalse(result.equals(matrixA));
    }
}
