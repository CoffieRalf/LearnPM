package vl08.refactoring;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class PersonTest {

    @Test
    public void testPerson() {
        Person p = new Person();
        assertNotNull(p);
    }

    @Test
    public void testSetNme() {
        Person p = new Person();
        // p.setNme("Hello World");
    }

    @Test
    public void testGetNme() {
        Person p = new Person();
        // p.setNme("Hello World");
        // assertEquals("", p.getNme());
    }

}
