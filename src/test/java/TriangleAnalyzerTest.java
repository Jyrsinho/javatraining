import Triangles.TriangleAnalyzer;
import org.junit.jupiter.api.BeforeEach;
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
    public void testShouldReturnThreeForEquilateralTriangle() {
        int[] sides = {3, 3, 3};
        assertEquals(3, triangleAnalyzer.countEqualSides(sides));
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
    public void testShouldReturnEquilateralWhenAllSidesAreOfEqualLength() {
        TriangleAnalyzer triangleAnalyzer = new TriangleAnalyzer(3,3,3);
        assertEquals("equilateral", triangleAnalyzer.analyze());
    }

    @Test
    public void testShouldReturnscaleneWhenNoTwoSidesAreEqual() {
        TriangleAnalyzer triangleAnalyzer = new TriangleAnalyzer(3,2,1);
        assertEquals("scalene", triangleAnalyzer.analyze());
    }

    @Test
    public void testShouldReturnIsoscelesWhenTwoSidesAreEqual() {
        TriangleAnalyzer triangleAnalyzer = new TriangleAnalyzer(3,2,2);
        assertEquals("isosceles", triangleAnalyzer.analyze());
    }

    @Test
    public void testShouldReturnNotATriangleWhenGiveZeroZeroZero() {
        TriangleAnalyzer triangleAnalyzer = new TriangleAnalyzer(0,0,0);
        assertEquals("not a triangle", triangleAnalyzer.analyze());
    }

    @Test
    public void testShouldReturnNotATriangleWhenGivenANegativeSide() {
        TriangleAnalyzer triangleAnalyzer = new TriangleAnalyzer(-3,3,3);
        assertEquals("not a triangle", triangleAnalyzer.analyze());
    }
}
