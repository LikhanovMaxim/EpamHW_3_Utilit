package IntArrayUtils;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class PrimeTest {

    @Test
    public void zeroApply() throws Exception {
        PredicateInt predicate = new Prime();
        int zero = 0;
        assertFalse(predicate.apply(zero));
    }

    @Test
    public void oneApply() throws Exception {
        PredicateInt predicate = new Prime();
        int one = 1;
        assertTrue(predicate.apply(one));
    }

    @Test
    public void PrimeApply() throws Exception {
        PredicateInt predicate = new Prime();
        int prime = 2;
        int negativePrime = -13;
        assertTrue(predicate.apply(prime));
        assertTrue(predicate.apply(negativePrime));
    }

    @Test
    public void noPrimeApply() throws Exception {
        PredicateInt predicate = new Prime();
        int noPrime = 22;
        int negativeNoPrime = -51;
        assertFalse(predicate.apply(noPrime));
        assertFalse(predicate.apply(negativeNoPrime));
    }
}