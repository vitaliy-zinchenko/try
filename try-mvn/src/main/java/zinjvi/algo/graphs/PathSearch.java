package zinjvi.algo.graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Vitalii Zinchenko
 */
public class PathSearch {

    private Graph graph;
    private Integer from;

    /**
     * The previous step in the path of the index.
     * For example, index[3] = 1, for vertex 3 the previous vertex in the path is 1
     */
    private Integer[] index;
    private boolean[] marked;

    public PathSearch(Graph graph, Integer from) {
        this.graph = graph;
        this.from = from;
        marked = new boolean[graph.getVertices()];
        for (int i = 0; i < marked.length; i++) {
            marked[i] = false;
        }
        this.index = new Integer[graph.getVertices()];

        buildIndex(from);
    }

    public boolean isConnectedToStart(Integer vertex) {
        return marked[vertex];
    }

    private void buildIndex(Integer vertex) {
        marked[vertex] = true;
        for (Integer child : graph.getAdjacency(vertex)) {
            if (!marked[child]) {
                index[child] = vertex;
                buildIndex(child);
            }
        }
    }

    public Iterable<Integer> search(Integer to) {
        List<Integer> path = new LinkedList<>();
        for (int i = to; i != from; i = index[i]) {
            path.add(i);
        }
        path.add(from);
        return path;
    }

}
