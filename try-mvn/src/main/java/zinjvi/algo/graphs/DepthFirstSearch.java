package zinjvi.algo.graphs;

/**
 * @author Vitalii Zinchenko
 */
public class DepthFirstSearch {

    private Graph graph;
    private Integer start;

    private boolean[] marked;

    public DepthFirstSearch(Graph graph, Integer start) {
        this.graph = graph;
        this.start = start;
    }

    public void search() {
        this.marked = new boolean[this.graph.getVertices()];
        for (int i = 0; i < marked.length; i++) {
            this.marked[i] = false;
        }
        markDeep(this.start);
    }

    private void markDeep(Integer vertex) {
        if (marked[vertex])
            return;
        marked[vertex] = true;
        for (Integer child : graph.getAdjacency(vertex)) {
            markDeep(child);
        }
    }

    public boolean marked(Integer vertex) {
        return marked[vertex];
    }



}
