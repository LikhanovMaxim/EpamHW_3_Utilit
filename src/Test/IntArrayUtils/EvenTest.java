package IntArrayUtils;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.*;

public class EvenTest {

    @Test
    public void zeroApply() throws Exception {
        PredicateInt predicate = new Even();
        int zero = 0;
        assertTrue(predicate.apply(zero));
    }

    @Test
    public void evenApply() throws Exception {
        PredicateInt predicate = new Even();
        int even = 2;
        int negativeEven = -24;
        assertTrue(predicate.apply(even));
        assertTrue(predicate.apply(negativeEven));
    }

    @Test
    public void noEvenApply() throws Exception {
        PredicateInt predicate = new Even();
        int noEven = 13;
        int negativeNoEven = -1;
        assertFalse(predicate.apply(noEven));
        assertFalse(predicate.apply(negativeNoEven));
    }
}