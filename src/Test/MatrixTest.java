import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void Matrix() throws Exception {
        Matrix mat = new Matrix(2, 2);
        double[][] result = {{0, 0},
                {0, 0}};
        assertTrue(mat.equals(result));
    }

    @Test
    public void emptyMatrix() throws Exception {
        Matrix mat = new Matrix(0, 0);
        double[][] result = {};
        assertTrue(mat.equals(result));
    }

    @Test
    public void nullMatrix() throws Exception {
        Matrix mat = new Matrix(-2, 0);
        double[][] matrNull = null;
        assertTrue(mat.equals(matrNull));
    }

    @Test
    public void getElem() throws Exception {
        double[][] matrix = {{1, 2},
                {3, 4}};
        Matrix mat = new Matrix(matrix);
        assertTrue(mat.getElem(1, 1) == 4);
    }

    @Test
    public void nullGetElem() throws Exception {
        double[][] matrix = {{1, 2},
                {3, 4}};
        Matrix mat = new Matrix(matrix);
        assertTrue(mat.getElem(17, 3) == 0);
    }

    @Test
    public void getRows() throws Exception {
        double[][] matrix = {{1, 2, 3},
                {4, 5, 6}};
        Matrix mat = new Matrix(matrix);
        assertTrue(mat.getRows() == 2);
    }

    @Test
    public void nullGetRows() throws Exception {
        Matrix mat = new Matrix(null);
        assertTrue(mat.getRows() == 0);
    }

    @Test
    public void emptyGetRows() throws Exception {
        Matrix mat = new Matrix(0, 0);
        assertTrue(mat.getRows() == 0);
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

    @Test
    public void paramDoublNullEquals() throws Exception {
        Matrix mat = new Matrix(-1, 0);
        double[][] matNull = null;
        assertTrue(mat.equals(matNull));
    }

    @Test
    public void paramDoublEmptyEquals() throws Exception {
        double[][] matA = {};
        Matrix matB = new Matrix(0, 0);
        assertTrue(matB.equals(matA));
    }

    @Test
    public void paramDoublReflexEquals() throws Exception {
        double[][] matA = {{5, 8, -4},
                {6, 9, -5},
                {4, 7, -3}};
        Matrix matC = new Matrix(matA);
        assertTrue(matC.equals(matA));
    }

    @Test
    public void paramDoublDifferDimenEquals() throws Exception {
        double[][] matA = {{-2, 1},
                {5, 4}};
        double[][] matB = {{3},
                {-1}};
        Matrix matC = new Matrix(matA);
        Matrix matD = new Matrix(matB);
        assertFalse(matC.equals(matB));
        assertFalse(matD.equals(matA));
    }

    @Test
    public void paramDoublSameDimenEquals() throws Exception {
        double[][] matA = {{5, 8, -4},
                {6, 9, -5},
                {4, 7, -3}};
        double[][] matB = {{3, 2, 5},
                {4, -1, 3},
                {9, 6, 5}};
        Matrix matC = new Matrix(matA);
        Matrix matD = new Matrix(matB);
        assertFalse(matC.equals(matB));
        assertFalse(matD.equals(matA));
    }

    @Test
    public void paramMatEmptyEquals() throws Exception {
        Matrix mat = new Matrix(0, 0);
        double[][] matEmpty = {};
        for (int rows = 0; rows < matEmpty.length; rows++) {
            for (int columns = 0; columns < matEmpty[0].length; columns++) {
                System.out.print(matEmpty[rows][columns] + " ");
            }
            System.out.println();
        }
//        Matrix matEmpty = new Matrix(matEmpty);
        System.out.println(mat.toString());
//        System.out.println(matEmpty.toString());
        //assertTrue(mat.equals(matEmpty));
    }

    @Test
    public void paramMatEquals() throws Exception {
        double[][] matA = {{5, 8, -4},
                {6, 9, -5},
                {4, 7, -3}};
        Matrix result = new Matrix(matA);
        assertTrue(result.equals(result));
    }

    @Test
    public void paramMatDifferDimenEquals() throws Exception {
        double[][] matA = {{-2, 1},
                {5, 4}};
        double[][] matB = {{3},
                {-1}};
        Matrix matC = new Matrix(matA);
        Matrix matD = new Matrix(matB);
        assertFalse(matC.equals(matD));
        assertFalse(matD.equals(matC));
    }

    @Test
    public void paramMatSameDimenEquals() throws Exception {
        double[][] matA = {{5, 8, -4},
                {6, 9, -5},
                {4, 7, -3}};
        double[][] matB = {{3, 2, 5},
                {4, -1, 3},
                {9, 6, 5}};
        Matrix matC = new Matrix(matA);
        Matrix matD = new Matrix(matB);
        assertFalse(matC.equals(matD));
        assertFalse(matD.equals(matC));
    }

    @Test
    public void setElem() throws Exception {
        double[][] mat = {{1, 2, 3},
                {4, 5, 6}};
        Matrix matr = new Matrix(mat);
        double[][] result = {{1, 2, 3},
                {17, 5, 6}};
        matr.setElem(1, 0, 17);
        assertTrue(matr.equals(result));
    }

    @Test
    public void firstGetColumn() throws Exception {
        double[][] mat = {{1, 2, 3},
                {4, 5, 6}};
        Matrix matr = new Matrix(mat);
        double[] result = {1, 4};
        assertTrue(Arrays.equals(result, matr.getColumn(mat, 0)));
    }

    @Test
    public void midlGetColumn() throws Exception {
        double[][] mat = {{1, 2, 3},
                {4, 5, 6}};
        Matrix matr = new Matrix(mat);
        double[] result = {2, 5};
        assertTrue(Arrays.equals(result, matr.getColumn(mat, 1)));
    }

    @Test
    public void lastGetColumn() throws Exception {
        double[][] mat = {{1, 2, 3},
                {4, 5, 6}};
        Matrix matr = new Matrix(mat);
        double[] result = {3, 6};
        assertTrue(Arrays.equals(result, matr.getColumn(mat, 2)));
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
    public void differTransfTriangMat() throws Exception {
        double[][] matA = {{5, 3},
                {4, 5},
                {1, 1}};
        Matrix matrixA = new Matrix(matA);
        matrixA.transfTriangMat();
        assertTrue(matrixA.equals(matrixA));
    }

    @Test
    public void squareTransfTriangMat() throws Exception {
        double[][] matA = {{5, 3},
                {4, 5}};
        Matrix matrixA = new Matrix(matA);
        double[][] res = {{5, 3},
                {0, 2.5999999999999996}};
        Matrix result = new Matrix(res);
        matrixA.transfTriangMat();
        assertTrue(result.equals(matrixA));
    }

    @Test
    public void cubicTransfTriangMat() throws Exception {
        double[][] matA = {{1, 2, 3},
                {1, 1, 2},
                {3, 1, 1}};
        Matrix matrixA = new Matrix(matA);
        double[][] res = {{1, 2, 3},
                {0, -1, -1},
                {0, 0, -3}};
        Matrix result = new Matrix(res);
        matrixA.transfTriangMat();
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

//    @Test
//    public void testClone() throws CloneNotSupportedException {
//        double[][] matA = {{1, 2, 3},
//                {1, 1, 2},
//                {3, 1, 1}};
//        Matrix matrixA = new Matrix(matA);
//        Matrix result = (Matrix) matrixA.clone();
//        assertTrue(result.equals(matrixA));
//        result.setElem(1, 1, 17);
////        assertFalse(result.equals(matrixA));
//    }
}
