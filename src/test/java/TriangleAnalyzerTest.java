import Triangles.TriangleAnalyzer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleAnalyzerTest {

    private TriangleAnalyzer triangleAnalyzer;


    @BeforeEach
    void setUp() {
        triangleAnalyzer = new TriangleAnalyzer(3,3,3);
    }

    @Test
    public void testShouldReturnZeroForScaleneTriangle() {
        int[] sides = {2, 3, 4};
        assertEquals(0, triangleAnalyzer.countEqualSides(sides));

    }

    @Test
    public void testShouldReturnTwoForEquilateralTriangle() {
        int[] sides = {3, 3, 3};
        assertEquals(2, triangleAnalyzer.countEqualSides(sides));
    }

    @Test
    public void testShouldReturnOneForIsoscelesTriangle1() {
        int[] sides = {2, 3, 3};
        assertEquals(1, triangleAnalyzer.countEqualSides(sides));
    }

    @Test
    public void testShouldReturnOneForIsoscelesTriangle2() {
        int[] sides = {3, 3, 2};
        assertEquals(1, triangleAnalyzer.countEqualSides(sides));
    }

    @Test
    public void testShouldReturnOneForIsoscelesTriangle3() {
        int[] sides = {3, 2, 3};
        assertEquals(1, triangleAnalyzer.countEqualSides(sides));
    }

    @Test
    public void testShouldReturnTwoForIsoscelesTriangle() {}

    @Disabled
    public void testShouldReturnEquilateralWhenAllSidesAreOfEqualLength() {
        TriangleAnalyzer triangleAnalyzer = new TriangleAnalyzer(3,3,3);
        assertEquals("equilateral", triangleAnalyzer.analyze());
    }

    @Disabled
    public void testShouldReturnscaleneWhenNoTwoSidesAreEqual() {
        TriangleAnalyzer triangleAnalyzer = new TriangleAnalyzer(3,2,1);
        assertEquals("scalene", triangleAnalyzer.analyze());
    }
}
