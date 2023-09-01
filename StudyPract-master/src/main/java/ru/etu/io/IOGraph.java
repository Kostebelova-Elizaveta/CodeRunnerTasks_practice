package ru.etu.io;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import javafx.util.Pair;
import ru.etu.graph.DirectedGraph;
import ru.etu.graph.Edge;
import ru.etu.graph.Graph;
import ru.etu.graph.GraphList;
import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class IOGraph {
    public IOGraph() {
    }

    public Graph loadGraph(String name) throws IOException {
        try (JsonReader reader = new JsonReader(new InputStreamReader(Files.newInputStream(Paths.get(name)), StandardCharsets.UTF_8))){
            Gson gson = new Gson();
            //JsonReader reader = new JsonReader(new InputStreamReader(Files.newInputStream(Paths.get(name)), StandardCharsets.UTF_8));
            JSONGraph savedGraph = gson.fromJson(reader, JSONGraph.class);
            //reader.close();
            Graph newGraph = savedGraph.getGraph();
            verifyGraph(newGraph);
            return newGraph;
        } catch (Exception ex) {
            throw new IOException(ex.getLocalizedMessage());
        }
    }

    public void saveGraph(String name, Graph graph, boolean isOriented) throws IOException {
        Gson gson = new Gson();
        JSONGraph graphToSave = new JSONGraph(graph, isOriented);
        Path filePath = Paths.get(name);
        if (!filePath.toFile().exists() && filePath.getParent() != null) {
            Files.createDirectories(filePath.getParent());
        }

        JsonWriter writer = new JsonWriter(new OutputStreamWriter(Files.newOutputStream(filePath), StandardCharsets.UTF_8));
        gson.toJson(graphToSave, JSONGraph.class, writer);
        writer.close();
    }

    public void saveGraph(String name, Graph graph) throws IOException {
        saveGraph(name, graph, (graph instanceof DirectedGraph));
    }

    private void verifyGraph(Graph graph) throws IOException{
        for (Edge edge : graph.getEdges()){
            if (edge.getData()<=0){
                throw new IOException("Invalid file: found an edge with non-positive weight!");
            }
        }
    }
}
