package zinjvi.algo.graphs;

/**
 * @author Vitalii Zinchenko
 */
public class ConnectedComponents {

    private Graph graph;
    private boolean[] marked;
    private Integer[] componentId;
    private int count;

    public ConnectedComponents(Graph graph) {
        this.graph = graph;

        count = 0;

        marked = new boolean[graph.getVertices()];
        for (int i = 0; i < graph.getVertices(); i++)
            marked[i] = false;

        componentId = new Integer[graph.getVertices()];

        for (int i = 0; i < graph.getVertices(); i++) {
            if (!marked[i]) {
                dfs(i);
                count++;
            }
        }
    }

    private void dfs(Integer vertex) {
        marked[vertex] = true;
        componentId[vertex] = count;
        for (Integer child : graph.getAdjacency(vertex)) {
            if (!marked[child])
                dfs(child);
        }
    }

    public boolean connected(Integer first, Integer second) {
        return componentId[first].equals(componentId[second]);
    }

    public int count() {
        return count;
    }

    public int id(int vertex) {
        return componentId[vertex];
    }

}
