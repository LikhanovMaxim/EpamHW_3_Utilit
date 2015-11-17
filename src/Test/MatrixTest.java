import org.junit.Test;

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
    public void EmptyMatrix() throws Exception {
        Matrix mat = new Matrix(0, 0);
        double[][] result = {};
        assertTrue(mat.equals(result));
    }

    @Test
    public void NullMatrix() throws Exception {
        Matrix mat = new Matrix(-2, 0);
        assertTrue(mat.equals(null));
    }
    @Test
    public void getElem() throws Exception {
        double[][] matrix = {{1, 2},
                             {3, 4}};
        Matrix mat = new Matrix(matrix, matrix.length, matrix[0].length);
        assertTrue(mat.getElem(1, 1) == 4);
    }
    @Test
    public void NullGetElem() throws Exception {
        double[][] matrix = {{1, 2},
                             {3, 4}};
        Matrix mat = new Matrix(matrix, matrix.length, matrix[0].length);
        assertTrue(mat.getElem(17, 3)==0);
    }
    @Test
    public void getRows() throws Exception {
        double[][] matrix = {{1, 2, 3},
                             {4, 5, 6}};
        Matrix mat = new Matrix(matrix, matrix.length, matrix[0].length);
        assertTrue(mat.getRows()==2);
    }
    @Test
    public void NullGetRows() throws Exception {
        Matrix mat = new Matrix(null, 0, 0);
        assertTrue(mat.getRows()==0);
    }
    @Test
    public void emptyGetRows() throws Exception {
        Matrix mat = new Matrix(0, 0);
        assertTrue(mat.getRows()==0);
    }
    @Test
    public void getColumn() throws Exception {
        double[][] matrix = {{1, 2, 3},
                {4, 5, 6}};
        Matrix mat = new Matrix(matrix, matrix.length, matrix[0].length);
        assertTrue(mat.getColumn()==2);
    }
    @Test
    public void NullGetColumn() throws Exception {
        Matrix mat = new Matrix(null, 0, 0);
        assertTrue(mat.getColumn()==0);
    }
    @Test
    public void emptyGetColumn() throws Exception {
        Matrix mat = new Matrix(0, 0);
        assertTrue(mat.getColumn()==0);
    }
}