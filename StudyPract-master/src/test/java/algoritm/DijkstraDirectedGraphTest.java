package algoritm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.etu.algoritm.Dijkstra;
import ru.etu.graph.DirectedGraphList;
import ru.etu.graph.Graph;
import ru.etu.graph.Vertex;

import java.util.ArrayList;
import java.util.List;

public class DijkstraDirectedGraphTest {

    Graph graph;

    @BeforeEach
    void before(){
        graph = new DirectedGraphList();
    }

    @Test
    void algGeneralTest() {
        Vertex v1 = graph.insertVertex("A");
        Vertex v2 = graph.insertVertex("B");
        Vertex v3 = graph.insertVertex("C");
        Vertex v4 = graph.insertVertex("D");
        Vertex v5 = graph.insertVertex("E");

        graph.insertEdge("A", "B", 1);
        graph.insertEdge("B", "C", 1);
        graph.insertEdge("C", "D", 1);
        graph.insertEdge("D", "E", 1);

        Dijkstra alg = new Dijkstra(graph);

        Assertions.assertTrue(alg.findPath(v1, v5));

        List<String> expected = new ArrayList<>();
        expected.add("A");
        expected.add("B");
        expected.add("C");
        expected.add("D");
        expected.add("E");

        Assertions.assertEquals(expected, alg.getPath());
    }

    @Test
    void algGeneralTest2() {
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        var finish = graph.insertVertex("E");
        var start = graph.insertVertex("F");

        graph.insertEdge("A", "B", 1);
        graph.insertEdge("A", "C", 2);
        graph.insertEdge("D", "A", 3);
        graph.insertEdge("B", "C", 4);
        graph.insertEdge("D", "C", 4);
        graph.insertEdge("B", "E", 5);
        graph.insertEdge("F", "D", 6);

        Dijkstra alg = new Dijkstra(graph);

        Assertions.assertTrue(alg.findPath(start, finish));

        List<String> expected = new ArrayList<>();
        expected.add("F");
        expected.add("D");
        expected.add("A");
        expected.add("B");
        expected.add("E");

        Assertions.assertEquals(expected, alg.getPath());
    }

    @Test
    void equalPathsTest() {
        var start = graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        var finish = graph.insertVertex("D");

        graph.insertEdge("A", "B", 4);
        graph.insertEdge("B", "D", 3);
        graph.insertEdge("A", "C", 3);
        graph.insertEdge("C", "D", 4);

        Dijkstra alg = new Dijkstra(graph);

        Assertions.assertTrue(alg.findPath(start, finish));

        List<String> expected = new ArrayList<>();
        expected.add("A");
        expected.add("C");
        expected.add("D");

        Assertions.assertEquals(expected, alg.getPath());
    }
}
