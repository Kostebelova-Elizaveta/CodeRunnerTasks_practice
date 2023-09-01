package graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.etu.graph.*;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphTest {
    DirectedGraphList graph;

    @BeforeEach
    void before() {
        graph = new DirectedGraphList();
    }


    @Test
    void getVerticesNumberTest() {
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");

        Assertions.assertEquals(3, graph.verticesNum());
    }

    @Test
    void getVerticesNumberAfterOneDeletedTest() {
        graph.insertVertex("A");
        graph.insertVertex("B");
        var vertexC = graph.insertVertex("C");

        graph.removeVertex(vertexC);

        Assertions.assertEquals(2, graph.verticesNum());
    }

    @Test
    void getVerticesNumberAfterAllDeletedTest() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");
        var vertexC = graph.insertVertex("C");

        graph.removeVertex(vertexA);
        graph.removeVertex(vertexB);
        graph.removeVertex(vertexC);

        Assertions.assertEquals(0, graph.verticesNum());
    }


    @Test
    void getEdgesNumberTest() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");
        var vertexC = graph.insertVertex("C");
        var vertexD = graph.insertVertex("D");

        graph.insertEdge(vertexA, vertexB, 5);
        graph.insertEdge(vertexA, vertexC, 4);
        graph.insertEdge(vertexA, vertexD, 5);

        Assertions.assertEquals(3, graph.edgesNum());
    }

    @Test
    void getEdgesNumberAfterOneDeletedTest() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");
        var vertexC = graph.insertVertex("C");
        var vertexD = graph.insertVertex("D");

        graph.insertEdge(vertexA, vertexB, 5);
        graph.insertEdge(vertexA, vertexC, 4);
        var edge = graph.insertEdge(vertexA, vertexD, 5);

        graph.removeEdge(edge);

        Assertions.assertEquals(2, graph.edgesNum());
    }

    @Test
    void getEdgesNumberAfterAllDeletedTest() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");
        var vertexC = graph.insertVertex("C");
        var vertexD = graph.insertVertex("D");

        var edge1 = graph.insertEdge(vertexA, vertexB, 5);
        var edge2 = graph.insertEdge(vertexA, vertexC, 4);
        var edge3 = graph.insertEdge(vertexA, vertexD, 5);

        graph.removeEdge(edge1);
        graph.removeEdge(edge2);
        graph.removeEdge(edge3);

        Assertions.assertEquals(0, graph.edgesNum());
    }


    @Test
    void getVerticesTest() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");
        var vertexC = graph.insertVertex("C");

        Assertions.assertEquals(3, graph.getVertices().size());

        ArrayList<Vertex> expected = new ArrayList<>() {{
            add(vertexA);
            add(vertexB);
            add(vertexC);
        }};

        List<Vertex> real = graph.getVertices();

        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), real.get(i));
        }
    }

    @Test
    void getVerticesOneDeletedTest() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");
        var vertexC = graph.insertVertex("C");

        graph.removeVertex(vertexC);

        Assertions.assertEquals(2, graph.getVertices().size());

        ArrayList<Vertex> expected = new ArrayList<>() {{
            add(vertexA);
            add(vertexB);
        }};

        List<Vertex> real = graph.getVertices();

        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), real.get(i));
        }
    }

    @Test
    void getVerticesAllDeletedTest() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");
        var vertexC = graph.insertVertex("C");

        graph.removeVertex(vertexA);
        graph.removeVertex(vertexB);
        graph.removeVertex(vertexC);

        Assertions.assertEquals(0, graph.getVertices().size());
    }


    @Test
    void getEdgesTest() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");
        var vertexC = graph.insertVertex("C");
        var vertexD = graph.insertVertex("D");

        var edge1 = graph.insertEdge(vertexA, vertexB, 5);
        var edge2 = graph.insertEdge(vertexA, vertexC, 4);
        var edge3 = graph.insertEdge(vertexA, vertexD, 5);

        Assertions.assertEquals(3, graph.getEdges().size());

        ArrayList<Edge> expected = new ArrayList<>() {{
            add(edge1);
            add(edge2);
            add(edge3);
        }};

        List<Edge> real = graph.getEdges();

        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), real.get(i));
        }
    }

    @Test
    void getEdgesOneDeletedTest() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");
        var vertexC = graph.insertVertex("C");
        var vertexD = graph.insertVertex("D");

        var edge1 = graph.insertEdge(vertexA, vertexB, 5);
        var edge2 = graph.insertEdge(vertexA, vertexC, 4);
        var edge3 = graph.insertEdge(vertexA, vertexD, 5);

        graph.removeEdge(edge3);

        Assertions.assertEquals(2, graph.getEdges().size());

        ArrayList<Edge> expected = new ArrayList<>() {{
            add(edge1);
            add(edge2);
        }};

        List<Edge> real = graph.getEdges();

        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), real.get(i));
        }
    }

    @Test
    void getEdgesAllDeletedTest() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");
        var vertexC = graph.insertVertex("C");
        var vertexD = graph.insertVertex("D");

        var edge1 = graph.insertEdge(vertexA, vertexB, 5);
        var edge2 = graph.insertEdge(vertexA, vertexC, 4);
        var edge3 = graph.insertEdge(vertexA, vertexD, 5);

        graph.removeEdge(edge1);
        graph.removeEdge(edge2);
        graph.removeEdge(edge3);

        Assertions.assertEquals(0, graph.getEdges().size());
    }


    @Test
    void checkingIncidentEdges() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");
        var vertexC = graph.insertVertex("C");
        var vertexD = graph.insertVertex("D");

        graph.insertEdge(vertexA, vertexB, 2);
        graph.insertEdge(vertexA, vertexC, 2);
        graph.insertEdge(vertexD, vertexA, 2);
        Assertions.assertEquals(2, graph.incidentEdges(vertexA).size());
    }

    @Test
    void checkingIncidentEdgesWithVertexFromGraphTest() {
        Assertions.assertDoesNotThrow(() -> {
            var vertexA = graph.insertVertex("A");
            var vertexB = graph.insertVertex("B");

            graph.insertEdge(vertexA, vertexB, 2);
            graph.incidentEdges(vertexA);
        });
    }

    @Test
    void checkingIncidentEdgesWithVertexNotFromGraphTest() {
        var thrown = Assertions.assertThrows(InvalidVertexException.class, () -> {
            var vertexA = graph.insertVertex("A");
            var vertexB = new Vertex("B");
            var vertexC = graph.insertVertex("C");

            graph.insertEdge(vertexA, vertexC, 2);
            graph.incidentEdges(vertexB);
        });
    }


    @Test
    void checkingInboundEdgesEdges() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");
        var vertexD = graph.insertVertex("D");

        graph.insertEdge(vertexA, vertexB, 2);
        graph.insertEdge(vertexA, vertexD, 2);
        graph.insertEdge(vertexD, vertexB, 2);
        Assertions.assertEquals(2, graph.inboundEdges(vertexB).size());
    }

    @Test
    void checkingInboundEdgesWithVertexFromGraphTest() {
        Assertions.assertDoesNotThrow(() -> {
            var vertexA = graph.insertVertex("A");
            var vertexB = graph.insertVertex("B");

            graph.insertEdge(vertexA, vertexB, 2);
            graph.inboundEdges(vertexA);
        });
    }

    @Test
    void checkingInboundEdgesWithVertexNotFromGraphTest() {
        var thrown = Assertions.assertThrows(InvalidVertexException.class, () -> {
            var vertexA = graph.insertVertex("A");
            var vertexB = new Vertex("B");
            var vertexC = graph.insertVertex("C");

            graph.insertEdge(vertexA, vertexC, 2);
            graph.inboundEdges(vertexB);
        });
    }


    @Test
    void checkingOppositeVertexWithVertexAndEdgeBothInGraphTest() {
        Assertions.assertDoesNotThrow(() -> {
            var vertexA = graph.insertVertex("A");
            var vertexB = graph.insertVertex("B");

            var edgeAB = graph.insertEdge(vertexA, vertexB, 2);
            var result = graph.opposite(vertexA, edgeAB);
            Assertions.assertEquals(vertexB, result);
            result = graph.opposite(vertexB, edgeAB);
            Assertions.assertEquals(vertexA, result);
        });


    }

    @Test
    void checkingOppositeVertexWithVertexAndEdgeAnyNotInGraphTest() {
        Assertions.assertThrows(InvalidVertexException.class, () -> {
            var vertexA = graph.insertVertex("A");
            var vertexB = new Vertex("B");
            var vertexC = graph.insertVertex("C");

            var edgeAC = graph.insertEdge(vertexA, vertexC, 2);
            graph.opposite(vertexB, edgeAC);
        });

        graph = new DirectedGraphList();

        Assertions.assertThrows(InvalidEdgeException.class, () -> {
            var vertexA = graph.insertVertex("A");
            var vertexB = graph.insertVertex("B");

            var edgeAB = new Edge(2, vertexA, vertexB);
            graph.opposite(vertexB, edgeAB);
        });

        graph = new DirectedGraphList();

        Assertions.assertThrows(InvalidVertexException.class, () -> {
            var vertexA = graph.insertVertex("A");
            var vertexB = new Vertex("B");

            var edgeAB = new Edge(2, vertexA, vertexB);
            graph.opposite(vertexB, edgeAB);
        });
    }

    @Test
    void checkingOppositeVertexWhileEdgeDoesNotHaveVertexTest() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");
        var vertexC = graph.insertVertex("C");

        var edgeAC = graph.insertEdge(vertexA, vertexC, 2);
        var result = graph.opposite(vertexB, edgeAC);

        Assertions.assertNull(result);
    }


    @Test
    void areConnectedBothExistsConnectedTest() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");

        var edgeAB = graph.insertEdge(vertexA, vertexB, 2);

        var result = graph.areConnected(vertexB, vertexA);
        Assertions.assertFalse(result);

        result = graph.areConnected(vertexA, vertexB);
        Assertions.assertTrue(result);
    }

    @Test
    void areConnectedSameVertexTest() {
        var vertexA = graph.insertVertex("A");

        var result = graph.areConnected(vertexA, vertexA);
        Assertions.assertFalse(result);
    }

    @Test
    void areConnectedBothExistsNotConnectedTest() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");

        var result = graph.areConnected(vertexB, vertexA);
        Assertions.assertFalse(result);

        result = graph.areConnected(vertexA, vertexB);
        Assertions.assertFalse(result);
    }

    @Test
    void areConnectedAnyDoesNotExistTest() {
        var vertexA = graph.insertVertex("A");
        var vertexB = new Vertex("B");

        var edgeAB = new Edge(2, vertexA, vertexB);

        Assertions.assertThrows(InvalidVertexException.class, () -> {
            graph.areConnected(vertexB, vertexA);
        });

        graph = new DirectedGraphList();

        var vertexA1 = new Vertex("A");
        var vertexB1 = graph.insertVertex("B");

        var edgeAB1 = new Edge(2, vertexA, vertexB);

        Assertions.assertThrows(InvalidVertexException.class, () -> {
            graph.areConnected(vertexB1, vertexA1);
        });
    }


    @Test
    void newVerticesCreationSameVerticesNameTest() {
        var thrown = Assertions.assertThrows(InvalidVertexException.class, () -> {
            var vertexA1 = graph.insertVertex("A");
            var vertexA2 = graph.insertVertex("A");
        });
    }

    @Test
    void newVertexCreationTest() {
        Assertions.assertDoesNotThrow(() -> {
            var vertexB = graph.insertVertex("B");
        });
    }

    @Test
    void newVertexNullNameCreationTest() {
        var thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            var vertexNull = graph.insertVertex(null);
        });
    }


    @Test
    void creatingEdgeWithVertexNotFromGraphTest() {
        var thrown = Assertions.assertThrows(InvalidVertexException.class, () -> {
            var vertexA = graph.insertVertex("A");
            var vertexB = new Vertex("B");

            graph.insertEdge(vertexA, vertexB, 2);
        });
    }

    @Test
    void loopEdgeCreationTest() {
        Assertions.assertThrows(InvalidVertexException.class, () -> {
            var vertexA = graph.insertVertex("A");

            graph.insertEdge(vertexA, vertexA, 2);
        });
    }

    @Test
    void newEdgeCreationSameEdgesLengthWithDifferentPairsTest() {
        Assertions.assertDoesNotThrow(() -> {
            var vertexA = graph.insertVertex("A");
            var vertexB = graph.insertVertex("B");
            var vertexC = graph.insertVertex("C");

            graph.insertEdge(vertexA, vertexB, 2);
            graph.insertEdge(vertexA, vertexC, 2);
        });
    }

    @Test
    void newEdgeCreationSameEdgesLengthWithSamePairsTest() {
        var thrown = Assertions.assertThrows(InvalidEdgeException.class, () -> {
            var vertexA = graph.insertVertex("A");
            var vertexB = graph.insertVertex("B");

            graph.insertEdge(vertexA, vertexB, 2);
            graph.insertEdge(vertexA, vertexB, 2);
        });
    }

    @Test
    void newEdgeCreationSameEdgesLengthWithSamePairsDifferentWeightTest() {
        var thrown = Assertions.assertThrows(InvalidEdgeException.class, () -> {
            var vertexA = graph.insertVertex("A");
            var vertexB = graph.insertVertex("B");

            graph.insertEdge(vertexA, vertexB, 2);
            graph.insertEdge(vertexA, vertexB, 4);
        });
    }

    @Test
    void newEdgeCreationWithoutRealVerticesTest() {
        var thrown = Assertions.assertThrows(InvalidVertexException.class, () -> {
            graph.insertEdge("A", "B", 2);
        });
    }

    @Test
    void oppositeDirectionEdgesWithSameWeightTest() {
        Assertions.assertDoesNotThrow(() -> {
            var vertexA = graph.insertVertex("A");
            var vertexB = graph.insertVertex("B");

            graph.insertEdge(vertexA, vertexB, 2);
            graph.insertEdge(vertexB, vertexA, 2);
        });
    }

    @Test
    void oppositeDirectionEdgesWithDifferentWeightTest() {
        Assertions.assertDoesNotThrow(() -> {
            var vertexA = graph.insertVertex("A");
            var vertexB = graph.insertVertex("B");

            graph.insertEdge(vertexA, vertexB, 2);
            graph.insertEdge(vertexB, vertexA, 12);
        });
    }


    @Test
    void removeVertexWithoutRealVertexTest() {
        Assertions.assertDoesNotThrow(() -> {
            graph.insertVertex("A");

            graph.removeVertex(new Vertex("A"));
        });
    }

    @Test
    void removeVertexWithRealVertexTest() {
        Assertions.assertDoesNotThrow(() -> {
            var vertex = graph.insertVertex("A");

            graph.removeVertex(vertex);
        });
    }

    @Test
    void removeVertexWithoutAnyVerticesTest() {
        Assertions.assertThrows(InvalidVertexException.class, () -> {
            graph.removeVertex(new Vertex("A"));
        });
    }

    @Test
    void removeEdgeWithoutRealEdgeTest() {
        Assertions.assertDoesNotThrow(() -> {
            var vertexA = graph.insertVertex("A");
            var vertexB = graph.insertVertex("B");

            graph.insertEdge(vertexA, vertexB, 2);

            graph.removeEdge(new Edge(2, new Vertex("A"), vertexB));
        });
    }
    @Test
    void removeEdgeWithRealEdgeTest() {
        Assertions.assertDoesNotThrow(() -> {
            var vertexA = graph.insertVertex("A");
            var vertexB = graph.insertVertex("B");

            var edge = graph.insertEdge(vertexA, vertexB, 2);

            graph.removeEdge(edge);
        });
    }

    @Test
    void removeEdgeWithoutAnyEdgesTest() {
        Assertions.assertThrows(InvalidEdgeException.class, () -> {

            graph.removeEdge(new Edge(2, new Vertex("A"), new Vertex("B")));
        });
    }


    @Test
    void getEdgeVerticesNormalTest() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");
        var vertexC = graph.insertVertex("C");

        var origEdge = graph.insertEdge(vertexA, vertexB, 2);
        graph.insertEdge(vertexA, vertexC, 2);

        Assertions.assertDoesNotThrow(() -> {
            graph.getEdge(vertexA, vertexB);
        });

        var gotEdge = graph.getEdge(vertexA, vertexB);

        Assertions.assertEquals(origEdge, gotEdge);
    }

    @Test
    void getEdgeVerticesVertexNotInGraphTest() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");
        var vertexC = graph.insertVertex("C");

        graph.insertEdge(vertexA, vertexB, 2);
        graph.insertEdge(vertexA, vertexC, 2);

        Assertions.assertThrows(InvalidVertexException.class, () -> {
            graph.getEdge(vertexA, new Vertex("D"));
        });
    }

    @Test
    void getEdgeVerticesEdgeNotExistsTest() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");

        var gotEdge = graph.getEdge(vertexA, vertexB);

        Assertions.assertNull(gotEdge);
    }


    @Test
    void getEdgeStringsNormalTest() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");
        var vertexC = graph.insertVertex("C");

        var origEdge = graph.insertEdge(vertexA, vertexB, 2);
        graph.insertEdge(vertexA, vertexC, 2);

        Assertions.assertDoesNotThrow(() -> {
            graph.getEdge("A", "B");
        });

        var gotEdge = graph.getEdge("A", "B");

        Assertions.assertEquals(origEdge, gotEdge);
    }

    @Test
    void getEdgeStringsVertexNotInGraphTest() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");
        var vertexC = graph.insertVertex("C");

        graph.insertEdge(vertexA, vertexB, 2);
        graph.insertEdge(vertexA, vertexC, 2);

        Assertions.assertThrows(InvalidVertexException.class, () -> {
            graph.getEdge("A", "D");
        });
    }

    @Test
    void getEdgeStringsEdgeNotExistsTest() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");

        var gotEdge = graph.getEdge("A", "B");

        Assertions.assertNull(gotEdge);
    }


    @Test
    void GetVertexNormalText() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");

        Assertions.assertDoesNotThrow(() -> {
            graph.getVertex("A");
        });
    }

    @Test
    void GetVertexNotExistsText() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");

        Assertions.assertThrows(InvalidVertexException.class, () -> {
            graph.getVertex("C");
        });
    }

    @Test
    void GetVertexNullText() {
        var vertexA = graph.insertVertex("A");
        var vertexB = graph.insertVertex("B");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            graph.getVertex(null);
        });
    }


}
