package GenericClass;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenericClassTest<T> {


    @BeforeEach
    void setUp() {
    }


    @Test
    public void testShouldReturnTheStringWhenGivenString() {
        String data = "Hello";
        Generic<String> generic = new Generic<>(data);

        assertEquals("Hello", generic.getValue());

    }


    @Test
    public void testShouldPrintTheIntegerWhenGivenInteger() {
        int data = 123;
        Generic<Integer> generic = new Generic<>(data);
        assertEquals(123, generic.getValue());
    }


    @Test
    public void testShouldDeclareStringAsStringWhenGivenString() {
        String data = "Hello";
        Generic<String> generic = new Generic<>(data);
        assertEquals( "String", generic.showType());
    }


    @Test
    public void testShouldDeclareIntegerAsIntegerWhenGivenInteger() {
        int data = 123;
        Generic<Integer> generic = new Generic<>(data);
        assertEquals( "Integer", generic.showType());
    }

    @Test
    public void testShouldGiveAnOutputOfTwoLinesWhenGivenOneElementToPrint() {

        ArrayList<T> input = new ArrayList<>();
        Generic<Integer> data0 = new Generic<>(1);
        Generic<Integer> data1 = new Generic<>(1);
        Generic<String> data2 = new Generic<>("Hello");

        GenericContainer<T> inputContainer = new GenericContainer<>(input);

        Printer printer = new Printer(inputContainer);

        assertEquals(2, printer.print());
    }



}
