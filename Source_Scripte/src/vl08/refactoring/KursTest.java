package vl08.refactoring;

/**
 * @author Carsten Gips
 * @since 28.02.2016
 *
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KursTest {

    @Test
    public void testKurs() {
        Kurs k = new Kurs("Test", 42);
        assertEquals("Test", k.descr);
        assertEquals(42, k.cps);
    }

}
