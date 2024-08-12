package GenericClass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenericClassTest {

    @Test
    public void testShouldPrintTheStringWhenGivenString() {
        Printer printer = new Printer();

        assertEquals("Hello", printer.getDataAsString("Hello"));

    }

    @Test
    public void testShouldPrintTheIntegerWhenGivenInteger() {
        Printer printer = new Printer();
        assertEquals("123", printer.getDataAsString("123"));
    }

    @Test
    public void testShouldDeclareStringAsStringWhenGivenString() {

        Printer printer = new Printer();
        assertEquals( "String", printer.getDataAsClass("Hello"));
    }
}
