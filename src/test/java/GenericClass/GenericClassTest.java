package GenericClass;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GenericClassTest {

    @BeforeEach
    public void setUp() {}


    @Test
    public void testShouldPrintStrings() {
        Printer<String> printer = new Printer();
        String string1 = "Hello";
        printer.print(string1);
    }
}
