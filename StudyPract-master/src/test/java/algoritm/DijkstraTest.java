package algoritm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.etu.algoritm.Dijkstra;
import ru.etu.graph.Graph;
import ru.etu.graph.GraphList;
import ru.etu.graph.Vertex;

import java.util.ArrayList;
import java.util.List;


public class DijkstraTest {

    Graph graph;

    @BeforeEach
    void before(){
        graph = new GraphList();
    }

    @Test
    void algGeneralTest() {
        Vertex v1 = graph.insertVertex("A");
        Vertex v2 = graph.insertVertex("B");
        Vertex v3 = graph.insertVertex("C");
        Vertex v4 = graph.insertVertex("D");
        Vertex v5 = graph.insertVertex("E");

        graph.insertEdge("B", "A", 1);
        graph.insertEdge("C", "B", 1);
        graph.insertEdge("D", "C", 1);
        graph.insertEdge("E", "D", 1);

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
        Vertex v1 = graph.insertVertex("A");
        Vertex v21 = graph.insertVertex("B1");
        Vertex v22 = graph.insertVertex("B2");
        Vertex v31 = graph.insertVertex("C1");
        Vertex v32 = graph.insertVertex("C2");
        Vertex v41 = graph.insertVertex("D1");
        Vertex v42 = graph.insertVertex("D2");
        Vertex v5 = graph.insertVertex("E");

        graph.insertEdge("B1", "A", 1);
        graph.insertEdge("B2", "A", 1);
        graph.insertEdge("C1", "B1", 1);
        graph.insertEdge("C2", "B2", 1);
        graph.insertEdge("D1", "C1", 1);
        graph.insertEdge("D2", "C2", 1);
        graph.insertEdge("E", "D1", 1);
        graph.insertEdge("E", "D2", 1);

        Dijkstra alg = new Dijkstra(graph);

        Assertions.assertTrue(alg.findPath(v1, v5));

        List<String> expected = new ArrayList<>();
        expected.add("A");
        expected.add("B1");
        expected.add("C1");
        expected.add("D1");
        expected.add("E");

        Assertions.assertEquals(expected, alg.getPath());
        //System.out.println(alg.getPath().toString());
    }

    @Test
    void algGeneralTest3() {
        Vertex v1 = graph.insertVertex("A");
        Vertex v21 = graph.insertVertex("B1");
        Vertex v22 = graph.insertVertex("B2");
        Vertex v31 = graph.insertVertex("C1");
        Vertex v32 = graph.insertVertex("C2");
        Vertex v41 = graph.insertVertex("D1");
        Vertex v42 = graph.insertVertex("D2");
        Vertex v5 = graph.insertVertex("E");

        graph.insertEdge("B1", "A", 2);
        graph.insertEdge("B2", "A", 1);
        graph.insertEdge("C1", "B1", 1);
        graph.insertEdge("C2", "B2", 1);
        graph.insertEdge("D1", "C1", 1);
        graph.insertEdge("D2", "C2", 1);
        graph.insertEdge("E", "D1", 1);
        graph.insertEdge("E", "D2", 1);

        Dijkstra alg = new Dijkstra(graph);

        Assertions.assertTrue(alg.findPath(v1, v5));

        List<String> expected = new ArrayList<>();
        expected.add("A");
        expected.add("B2");
        expected.add("C2");
        expected.add("D2");
        expected.add("E");

        Assertions.assertEquals(expected, alg.getPath());
    }

    @Test
    void algGeneralTest4() {
        Vertex v1 = graph.insertVertex("A");
        Vertex v21 = graph.insertVertex("B1");
        Vertex v22 = graph.insertVertex("B2");
        Vertex v31 = graph.insertVertex("C1");
        Vertex v32 = graph.insertVertex("C2");
        Vertex v41 = graph.insertVertex("D1");
        Vertex v42 = graph.insertVertex("D2");
        Vertex v5 = graph.insertVertex("E");

        graph.insertEdge("B1", "A", 1);
        graph.insertEdge("B2", "A", 1);
        graph.insertEdge("C1", "B1", 1);
        graph.insertEdge("C2", "B2", 1);
        graph.insertEdge("D1", "C1", 1);
        graph.insertEdge("D2", "C2", 1);
        graph.insertEdge("E", "D1", 1);
        graph.insertEdge("E", "D2", 2);

        Dijkstra alg = new Dijkstra(graph);

        Assertions.assertTrue(alg.findPath(v1, v5));

        List<String> expected = new ArrayList<>();
        expected.add("A");
        expected.add("B1");
        expected.add("C1");
        expected.add("D1");
        expected.add("E");

        Assertions.assertEquals(expected, alg.getPath());
    }

    @Test
    void algTestNotGreedy() {
        Vertex v1 = graph.insertVertex("A");
        Vertex v21 = graph.insertVertex("B1");
        Vertex v22 = graph.insertVertex("B2");
        Vertex v31 = graph.insertVertex("C1");
        Vertex v32 = graph.insertVertex("C2");
        Vertex v41 = graph.insertVertex("D1");
        Vertex v42 = graph.insertVertex("D2");
        Vertex v5 = graph.insertVertex("E");

        graph.insertEdge("B1", "A", 10);
        graph.insertEdge("B2", "A", 1);
        graph.insertEdge("C1", "B1", 10);
        graph.insertEdge("C2", "B2", 1);
        graph.insertEdge("D1", "C1", 10);
        graph.insertEdge("D2", "C2", 1);
        graph.insertEdge("E", "D1", 10);
        graph.insertEdge("E", "D2", 50);

        Dijkstra alg = new Dijkstra(graph);

        Assertions.assertTrue(alg.findPath(v1, v5));

        List<String> expected = new ArrayList<>();
        expected.add("A");
        expected.add("B1");
        expected.add("C1");
        expected.add("D1");
        expected.add("E");

        Assertions.assertEquals(expected, alg.getPath());
    }

    @Test
    void algTestNotFound() {
        Vertex v1 = graph.insertVertex("A");
        Vertex v21 = graph.insertVertex("B1");
        Vertex v22 = graph.insertVertex("B2");
        Vertex v31 = graph.insertVertex("C1");
        Vertex v32 = graph.insertVertex("C2");
        Vertex v41 = graph.insertVertex("D1");
        Vertex v42 = graph.insertVertex("D2");
        Vertex v51 = graph.insertVertex("E1");
        Vertex v52 = graph.insertVertex("E2");

        graph.insertEdge("B1", "A", 10);
        graph.insertEdge("B2", "A", 1);
        graph.insertEdge("C1", "B1", 10);
        graph.insertEdge("C2", "B2", 1);
        graph.insertEdge("D1", "C1", 10);
        graph.insertEdge("D2", "C2", 1);
        graph.insertEdge("E2", "D1", 10);
        graph.insertEdge("E2", "D2", 50);

        Dijkstra alg = new Dijkstra(graph);

        Assertions.assertFalse(alg.findPath(v1, v51));
    }
}
