package AlgorithmsTwoTest.ComponentCounterTest;

import AlgorithmsTwo.CountComponents.Graph;
import AlgorithmsTwo.CountComponents.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphTest {

    @Test
    public void testGraphShouldAddTwoVertices() {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        int expected = 2;
        int actual = graph.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void testGraphShouldAddTwoEdgesAndTwoVertices() {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        int expected = 3;
        int actual = graph.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void testGraphShouldAddTwoEdgesAndTwoVertices2() {
        Graph graph = new Graph();
        graph.addEdge(0, 5);
        graph.addEdge(0, 7);
        Vertex zero = graph.getVertexByValue(0);
        graph.printGraph();
        assertEquals(1, zero.getEdges().getFirst().getId());
        assertEquals(2, zero.getEdges().getLast().getId());

    }
}
