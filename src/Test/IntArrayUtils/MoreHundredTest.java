package IntArrayUtils;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class MoreHundredTest {

    @Test
    public void exactlyHundredApply() throws Exception {
        int value = 100;
        PredicateIntArr predicate = new MoreHundred();
        assertFalse(predicate.apply(value));
    }

    @Test
    public void moreHundredApply() throws Exception {
        int value = 1000;
        PredicateIntArr predicate = new MoreHundred();
        assertTrue(predicate.apply(value));
    }

    @Test
    public void lessHundredApply() throws Exception {
        int value = 10;
        int negativeValue = -100;
        PredicateIntArr predicate = new MoreHundred();
        assertFalse(predicate.apply(value));
        assertFalse(predicate.apply(negativeValue));
    }
}