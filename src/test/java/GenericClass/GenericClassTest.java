package GenericClass;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenericClassTest {

    Printer printer;

    @BeforeEach
    void setUp() {
        printer = new Printer();
    }

    @Test
    public void testShouldPrintTheStringWhenGivenString() {
        assertEquals("Hello", printer.getDataAsString("Hello"));

    }

    @Test
    public void testShouldPrintTheIntegerWhenGivenInteger() {
        assertEquals("123", printer.getDataAsString("123"));
    }

    @Test
    public void testShouldDeclareStringAsStringWhenGivenString() {

        assertEquals( "String", printer.getDataAsClass("Hello"));
    }

    @Test
    public void testShouldDeclareIntegerAsIntegerWhenGivenInteger() {
        assertEquals( "Integer", printer.getDataAsClass(123));
    }

    @Test
    public void testShouldReturnArray() {

    }
}
