package ru.etu.io;

import ru.etu.graph.*;

import java.util.List;

public class JSONGraph {
    private boolean isOriented;
    private List<Vertex> vertices;
    private List<Edge> edges;

    public JSONGraph(Graph graph, boolean isOriented) {
        this.isOriented = isOriented;
        this.vertices = graph.getVertices();
        this.edges = graph.getEdges();
    }

    public Graph getGraph() {
        Graph newGraph = (isOriented ? new DirectedGraphList() : new GraphList());
        for (Vertex vertex : vertices) {
            newGraph.insertVertex(vertex.getData());
        }
        for (Edge edge : edges) {
            newGraph.insertEdge(edge.getVertexOutbound().getData(), edge.getVertexInbound().getData(), edge.getData());
        }
        return newGraph;
    }


}
