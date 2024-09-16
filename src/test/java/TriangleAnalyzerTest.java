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
    public void testShouldReturnOneForIsoscelesTriangle() {
        int[] sides = {3, 3, 4};
        assertEquals(1, triangleAnalyzer.countEqualSides(sides));
    }

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
