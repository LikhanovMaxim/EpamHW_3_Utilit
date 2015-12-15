package Matrix;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AddTest {

    @Test
    public void positiveNumberCalculation() throws Exception {
        OperationMatrix operation = new Add();
        assertTrue(19 == operation.calculation(12, 7));
        assertTrue(24 == operation.calculation(12, 12));
        assertTrue(9 == operation.calculation(1, 8));
    }

    @Test
    public void negativeNumbersCalculation() throws Exception {
        OperationMatrix operation = new Add();
        assertTrue(-19 == operation.calculation(-12, -7));
        assertTrue(-17 == operation.calculation(-5, -12));
        assertTrue(-6 == operation.calculation(-3, -3));
    }

    @Test
    public void differentSignCalculation() throws Exception {
        OperationMatrix operation = new Add();
        assertTrue(-5 == operation.calculation(-12, 7));
        assertTrue(-5 == operation.calculation(7, -12));
        assertTrue(-8 == operation.calculation(5, -13));
        assertTrue(8 == operation.calculation(-5, 13));
    }
}