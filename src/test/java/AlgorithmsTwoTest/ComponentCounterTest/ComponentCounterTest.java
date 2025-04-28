package AlgorithmsTwoTest.ComponentCounterTest;

import AlgorithmsTwo.CountComponents.ComponentCounter;
import AlgorithmsTwo.CountComponents.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComponentCounterTest {

    ComponentCounter componentCounter;
    Graph graph;

    @BeforeEach
    public void setUp() {
        graph = new Graph();
        componentCounter = new ComponentCounter();
    }


    @Test
    public void testComponentCounterShouldReturnZeroForEmptyGraph() {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);

        int actual = componentCounter.countComponents(graph);
        int expected = 1;
        assertEquals(expected, actual);

    }

    @Test
    public void testComponentCounterShouldReturnTwoForTwoComponentsInAGraph() {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        graph.addEdge(3 , 4);
        int actual = componentCounter.countComponents(graph);
        int expected = 2;
        assertEquals(expected, actual);
    }
}
