package zinjvi.algo.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Vitalii Zinchenko
 */
public class PathSearchBFS {

    private Graph graph;
    private Integer from;

    /**
     * The previous step in the path of the index.
     * For example, index[3] = 1, for vertex 3 the previous vertex in the path is 1
     */
    private Integer[] index;
    private boolean[] marked;

    public PathSearchBFS(Graph graph, Integer from) {
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
        Queue<Integer> queue = new LinkedList<>();
        marked[vertex] = true;
        queue.add(vertex);
        while (!queue.isEmpty()) {
            Integer next = queue.poll();
            for (Integer child : graph.getAdjacency(next)) {
                if (!marked[child]) {
                    index[child] = next;
                    marked[child] = true;
                    queue.add(child);
                }

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
