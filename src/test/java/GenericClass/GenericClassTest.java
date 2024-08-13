package GenericClass;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenericClassTest<T> {

    Printer<T> printer;
    T data;

    @BeforeEach
    void setUp() {
    }


    @Test
    public void testShouldPrintTheStringWhenGivenString() {
        String data = "Hello";
        Printer<String> printer = new Printer<>(data);

        assertEquals("Hello", printer.getDataAsString());

    }


    @Test
    public void testShouldPrintTheIntegerWhenGivenInteger() {
        int data = 123;
        Printer<Integer> printer = new Printer<>(data);
        assertEquals("123", printer.getDataAsString());
    }


    @Test
    public void testShouldDeclareStringAsStringWhenGivenString() {
        String data = "Hello";
        Printer<String> printer = new Printer<>(data);
        assertEquals( "String", printer.getDataAsClass());
    }


    @Test
    public void testShouldDeclareIntegerAsIntegerWhenGivenInteger() {
        int data = 123;
        Printer<Integer> printer = new Printer<>(data);
        assertEquals( "Integer", printer.getDataAsClass());
    }

/*
    @Disabled
    public void testShouldReturnOutputArrayOfFourElements() {
       T[] input = {2, 1,"gfg",2,5};


       assertEquals(4,printer.createOutput(input).length);

    }

 */
}
