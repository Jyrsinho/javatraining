import Triangles.TriangleAnalyzer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleAnalyzerTest {

    @Test
    public void testShouldReturnEquilateralWhenAllSidesAreOfEqualLength() {
        TriangleAnalyzer triangleAnalyzer = new TriangleAnalyzer(3,3,3);
        assertEquals("equilateral", triangleAnalyzer.analyze());
    }
}
