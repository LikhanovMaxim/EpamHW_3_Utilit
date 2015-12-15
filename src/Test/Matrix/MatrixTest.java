package Matrix;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class MatrixTest {
    @Test
    public void testMatrix() throws Exception {
        Matrix mat = new Matrix(new Size(2, 2));
        double[][] resultMat = {{0, 0},
                {0, 0}};
        Matrix result = new Matrix(resultMat);
        assertTrue(mat.equals(result));
    }

    @Test
    public void defaultConstructionMatrix() throws Exception {
        Size size = new Size();
        Matrix mat = new Matrix(size);
        double[][] resultMat = new double[1][1];
        Matrix result = new Matrix(resultMat);
        assertTrue(mat.equals(result));
    }

//    @Test
//    public void negativeSizeMatrix() throws Exception {
//        Matrix mat = new Matrix(new Size(-2, 0));
//        double[][] resultMat = new double[1][1];
//        Matrix result=new Matrix(resultMat);
//        assertTrue(mat.equals(result));
//    }

    @Test
    public void testGetElement() throws Exception {
        double[][] matrix = {{1, 2},
                {3, 4}};
        Matrix mat = new Matrix(matrix);
        assertTrue(mat.getElement(new Position(1, 1)) == 4);
    }

//    @Test
//    public void nullGetElement() throws Exception {
//        double[][] matrix = {{1, 2},
//                {3, 4}};
//        Matrix mat = new Matrix(matrix);
//        assertTrue(mat.getElement(new Position(17, 3)) == 0);
//    }

    @Test
    public void testSetElement() throws Exception {
        double[][] mat = {{1, 2, 3},
                {4, 5, 6}};
        Matrix matrix = new Matrix(mat);
        double[][] resultMat = {{1, 2, 3},
                {17, 5, 6}};
        Matrix result = new Matrix(resultMat);
        matrix.setElement(new Position(1, 0), 17);
        assertTrue(matrix.equals(result));
    }

    @Test
    public void testGetSize() throws Exception {
        double[][] mat = {{1, 2, 3},
                {4, 5, 6}};
        Matrix matrix = new Matrix(mat);
        Size size = matrix.getSize();
        assertTrue(size.getRow() == 2);
        assertTrue(size.getColumn() == 3);
    }

    @Test
    public void emptyEquals() throws Exception {
        Matrix mat = new Matrix(new Size());
        double[][] matEmpty = {{0}};
        Matrix matrixEmpty = new Matrix(matEmpty);
        assertTrue(mat.equals(matrixEmpty));
    }

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
    public void differDimenSubPerformOperation() throws Exception {
        OperationMatrix operation = new Sub();
        double[][] matA = {{-2, 1},
                {5, 4}};
        Matrix matrixA = new Matrix(matA);
        double[][] matB = {{3},
                {-1}};
        Matrix matrixB = new Matrix(matB);
        Matrix result = new Matrix(new Size());
        assertTrue(matrixA.perform(matrixB, operation).equals(result));
        matrixA = new Matrix(matA);
        assertTrue(matrixB.perform(matrixA, operation).equals(result));
    }

    @Test
    public void sameDimenSubPerformOperation() throws Exception {
        OperationMatrix operation = new Sub();
        double[][] matA = {{12, -3},
                {4, 16}};
        Matrix matrixA = new Matrix(matA);
        double[][] matB = {{9, -6},
                {6, -4}};
        Matrix matrixB = new Matrix(matB);
        double[][] result = {{3, 3},
                {-2, 20}};
        Matrix matrixResult = new Matrix(result);
        assertTrue(matrixResult.equals(matrixA.perform(matrixB, operation)));
        matrixA = new Matrix(matA);
        assertFalse(matrixResult.equals(matrixB.perform(matrixA, operation)));
    }

    @Test
    public void differDimenAddPerformOperation() throws Exception {
        OperationMatrix operation = new Add();
        double[][] matA = {{-2, 1},
                {5, 4}};
        Matrix matrixA = new Matrix(matA);
        double[][] matB = {{3},
                {-1}};
        Matrix matrixB = new Matrix(matB);
        Matrix result = new Matrix(new Size());
        assertTrue(matrixA.perform(matrixB, operation).equals(result));
        matrixA = new Matrix(matA);
        assertTrue(matrixB.perform(matrixA, operation).equals(result));
    }

    @Test
    public void sameDimenAddPerformOperation() throws Exception {
        OperationMatrix operation = new Add();
        double[][] matA = {{2, -3},
                {4, -6}};
        Matrix matrixA = new Matrix(matA);
        double[][] matB = {{9, -6},
                {6, -4}};
        Matrix matrixB = new Matrix(matB);
        double[][] result = {{11, -9},
                {10, -10}};
        Matrix matrixResult = new Matrix(result);
        assertTrue(matrixResult.equals(matrixA.perform(matrixB, operation)));
        matrixA = new Matrix(matA);
        assertTrue(matrixResult.equals(matrixB.perform(matrixA, operation)));
    }

    @Test
    public void firstGetRow() throws Exception {
        double[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        Matrix mat = new Matrix(matrix);
        double[] result = {1, 2, 3};
        assertTrue(Arrays.equals(result, mat.getRow(0)));
    }

    @Test
    public void middleGetRow() throws Exception {
        double[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        Matrix mat = new Matrix(matrix);
        double[] result = {4, 5, 6};
        assertTrue(Arrays.equals(result, mat.getRow(1)));
    }

    @Test
    public void lastGetRow() throws Exception {
        double[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        Matrix mat = new Matrix(matrix);
        double[] result = {7, 8, 9};
        assertTrue(Arrays.equals(result, mat.getRow(2)));
    }

    @Test
    public void firstGetColumn() throws Exception {
        double[][] mat = {{1, 2, 3},
                {4, 5, 6}};
        Matrix matrix = new Matrix(mat);
        double[] result = {1, 4};
        assertTrue(Arrays.equals(result, matrix.getColumn(0)));
    }

    @Test
    public void middleGetColumn() throws Exception {
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
    public void differDimenMulti() throws Exception {
        double[][] matA = {{-2, 1},
                {5, 4}};
        Matrix matrixA = new Matrix(matA);
        double[][] matB = {{3},
                {-1}};
        Matrix matrixB = new Matrix(matB);
        double[][] result = {{-7},
                {11}};
        Matrix matrixResult = new Matrix(result);
        assertTrue(matrixResult.equals(matrixA.multi(matrixB)));
        matrixA = new Matrix(matA);
        assertFalse(matrixResult.equals(matrixB.multi(matrixA)));
    }

    @Test(timeout = 1000)
    public void sameDimenMulti() throws Exception {
        double[][] matA = {{2, -3},
                {4, -6}};
        Matrix matrixA = new Matrix(matA);
        double[][] matB = {{9, -6},
                {6, -4}};
        Matrix matrixB = new Matrix(matB);
        double[][] result = {{0, 0},
                {0, 0}};
        Matrix matrixResult = new Matrix(result);
        assertTrue(matrixResult.equals(matrixA.multi(matrixB)));
        matrixA = new Matrix(matA);
        assertFalse(matrixResult.equals(matrixB.multi(matrixA)));
    }

    //    @Test
//    public void differToTriangularMatrix() throws Exception {
//        double[][] matA = {{5, 3},
//                {4, 5},
//                {1, 1}};
//        Matrix matrixA = new Matrix(matA);
//        matrixA.toTriangularMatrix();
//        assertTrue(matrixA.equals(matrixA));
//    }
//
//    @Test
//    public void squareToTriangularMatrix() throws Exception {
//        double[][] matA = {{5, 3},
//                {4, 5}};
//        Matrix matrixA = new Matrix(matA);
//        double[][] res = {{5, 3},
//                {0, 2.5999999999999996}};
//        Matrix result = new Matrix(res);
//        matrixA.toTriangularMatrix();
//        assertTrue(result.equals(matrixA));
//    }
//
//    @Test
//    public void cubicToTriangularMatrix() throws Exception {
//        double[][] matA = {{1, 2, 3},
//                {1, 1, 2},
//                {3, 1, 1}};
//        Matrix matrixA = new Matrix(matA);
//        double[][] res = {{1, 2, 3},
//                {0, -1, -1},
//                {0, 0, -3}};
//        Matrix result = new Matrix(res);
//        matrixA.toTriangularMatrix();
//        assertTrue(result.equals(matrixA));
//
//    }
//
//    @Test
//    public void differCalcDeterminate() throws Exception {
//        double[][] matA = {{5, 3},
//                {4, 5},
//                {1, 1}};
//        Matrix matrixA = new Matrix(matA);
//        double result = 0;
//        assertTrue(result == matrixA.calcDeterminate());
//    }
//
    @Test
    public void squareCalcDeterminate() throws Exception {
        double[][] matA = {{5, 3},
                {4, 5}};
        Matrix matrixA = new Matrix(matA);
        double result = 13;
        assertTrue(result == (int) matrixA.calcDeterminate() + 1);
    }

    @Test
    public void cubicCalcDeterminate() throws Exception {
        double[][] matA = {{1, 2, 3},
                {1, 1, 2},
                {3, 1, 1}};
        Matrix matrixA = new Matrix(matA);
        double result = 3;
        assertTrue(result == matrixA.calcDeterminate());
    }

    @Test
    public void testClone() throws CloneNotSupportedException {
        double[][] matA = {{1, 2, 3},
                {1, 1, 2},
                {3, 1, 1}};
        Matrix matrixA = new Matrix(matA);
        Matrix result = matrixA.clone();
        assertTrue(result.equals(matrixA));
        result.setElement(new Position(1, 1), 17);
        assertFalse(result.equals(matrixA));
    }
}
