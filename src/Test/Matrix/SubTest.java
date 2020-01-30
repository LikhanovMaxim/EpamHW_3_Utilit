package Matrix;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SubTest {
    @Test
    public void positiveNumberCalculation() throws Exception {
        OperationMatrix operation = new Sub();
        assertTrue(5 == operation.calculation(12, 7));
        assertTrue(0 == operation.calculation(12, 12));
        assertTrue(-7 == operation.calculation(1, 8));
    }

    @Test
    public void negativeNumbersCalculation() throws Exception {
        OperationMatrix operation = new Sub();
        assertTrue(-5 == operation.calculation(-12, -7));
        assertTrue(7 == operation.calculation(-5, -12));
        assertTrue(0 == operation.calculation(-3, -3));
    }

    @Test
    public void differentSignCalculation() throws Exception {
        OperationMatrix operation = new Sub();
        assertTrue(-19 == operation.calculation(-12, 7));
        assertTrue(19 == operation.calculation(7, -12));
        assertTrue(18 == operation.calculation(5, -13));
        assertTrue(-18 == operation.calculation(-5, 13));
    }
}