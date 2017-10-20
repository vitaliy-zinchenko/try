package zinjvi.algo.graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Vitalii Zinchenko
 */
public class Graph {

    private int vertices;
    private int edges;
    private List<Integer>[] adjacency;

    private Graph() {

    }

    public int getVertices() {
        return vertices;
    }

    public int getEdges() {
        return edges;
    }

    public List<Integer> getAdjacency(int vertex) {
        return adjacency[vertex];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.vertices).append(" vertices, ").append(this.edges).append(" edges").append(System.lineSeparator());
        for (int i = 0; i < adjacency.length; i++) {
            List<Integer> children = adjacency[i];
            s.append(i).append(": ");
            for (Integer child : children) {
                s.append(child).append(" ");
            }
            s.append(System.lineSeparator());
        }
        return s.toString();
    }

    public static final Builder builder() {
        return new Builder();
    }

    public static class Builder {
        public Graph build(int verticesCount, int edgesCount, Integer[]... edges) {
            Graph graph = new Graph();
            graph.vertices = verticesCount;
            graph.edges = edgesCount;
            graph.adjacency = buildAdjacency(edges, verticesCount);
            return graph;
        }

        private List<Integer>[] buildAdjacency(Integer[][] edges, int vertices) {
            List<Integer>[] adj = (List<Integer>[]) new List[vertices];
            for (int i = 0; i < vertices; i++) {
                adj[i] = new LinkedList<>();
            }
            for(Integer[] edge: edges) {
                Integer first = edge[0];
                Integer second = edge[1];
                adj[first].add(second);
                adj[second].add(first);
            }
            return adj;
        }
    }

}
