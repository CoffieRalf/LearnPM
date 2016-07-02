package vl08.refactoring;

/**
 * @author Carsten Gips
 * @since 28.02.2016
 *
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StudiTest {

    @Test
    public void testStudi() {
        Kurs k = new Kurs("myKurs", 9);
        Studi s = new Studi("Werner", 3, k);
        assertEquals(s.n, "Werner");
        assertEquals(s.c, 3);
        assertEquals(s.k, k);
    }

    @Test
    public void testSetNme() {
        Kurs k = new Kurs("myKurs", 9);
        Studi s = new Studi("Werner", 3, k);
        assertEquals(s.n, "Werner");

        s.n = "Heini";
        assertEquals(s.n, "Heini");
        assertEquals(s.c, 3);
        assertEquals(s.k, k);
    }

    @Test
    public void testPrtIf() {
        Kurs k = new Kurs("myKurs", 9);
        Studi s = new Studi("Werner", 3, k);
    }

}
