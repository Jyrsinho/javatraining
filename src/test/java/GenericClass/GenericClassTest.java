package GenericClass;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    }



}
