package GenericClass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenericClassTest {

    @Test
    public void testShouldPrintTheStringWhenGivenString() {
        Printer printer = new Printer();

        assertEquals("Hello", printer.print("Hello"));

    }
}
