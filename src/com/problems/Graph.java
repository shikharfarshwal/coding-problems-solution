package com.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private final Map<Vertex, List<Vertex>> adjVertices;

    public Graph(final Map<Vertex, List<Vertex>> adjVertices) {
        this.adjVertices = adjVertices;
    }

    public Map<Vertex, List<Vertex>> getAdjVertices() {
        return adjVertices;
    }

    private void addVertex(final String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    private void addEdge(final String label1, final String label2) {
        final Vertex v1 = new Vertex(label1);
        final Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    static class Vertex {
        String label;

        public Vertex(String label) {
            this.label = label;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Vertex vertex = (Vertex) o;

            return label.equals(vertex.label);
        }

        @Override
        public int hashCode() {
            return label.hashCode();
        }
    }


    public static void main(String[] args) {
        final Graph graph = new Graph(new HashMap<>());
        graph.addVertex("0");
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");


        graph.addEdge("0" , "1");
        graph.addEdge("0" , "2");
        graph.addEdge("1" , "3");
        graph.addEdge("2" , "4");
        graph.addEdge("3" , "4");
        graph.addEdge("4" , "5");
        graph.addEdge("5" , "6");
    }
}
