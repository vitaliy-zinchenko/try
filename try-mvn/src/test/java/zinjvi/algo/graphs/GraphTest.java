package zinjvi.algo.graphs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Vitalii Zinchenko
 */
public class GraphTest {

    private Graph graph;

    @Before
    public void before() {
        graph = Graph.builder().build(
                13,
                13,
                new Integer[]{0, 5},
                new Integer[]{4, 3},
                new Integer[]{0, 1},
                new Integer[]{9, 12},
                new Integer[]{6, 4},
                new Integer[]{5, 4},
                new Integer[]{0, 2},
                new Integer[]{11, 12},
                new Integer[]{9, 10},
                new Integer[]{0, 6},
                new Integer[]{7, 8},
                new Integer[]{9, 11},
                new Integer[]{5, 3}
        );
    }

    @Test
    public void test() {
        System.out.println(graph);
    }

    @Test
    public void connectedSearch() {
        DepthFirstSearch search = new DepthFirstSearch(graph, 9);
        search.search();

        Assert.assertTrue(search.marked(9));
        Assert.assertTrue(search.marked(10));
        Assert.assertTrue(search.marked(11));
        Assert.assertTrue(search.marked(12));
    }

    @Test
    public void pathSearch() {
        int start = 3;
        PathSearch search = new PathSearch(graph, start);
        for (int i = 0; i < graph.getVertices(); i++) {
            if (search.isConnectedToStart(i)) {
                Iterable<Integer> path = search.search(i);
                System.out.println("Path: " + path);
            } else {
                System.out.println(i + " is not connected to " + start);
            }
        }

    }

    @Test
    public void pathSearchBFS() {
        int start = 3;
        PathSearchBFS search = new PathSearchBFS(graph, start);
        for (int i = 0; i < graph.getVertices(); i++) {
            if (search.isConnectedToStart(i)) {
                Iterable<Integer> path = search.search(i);
                System.out.println("Path: " + path);
            } else {
                System.out.println(i + " is not connected to " + start);
            }
        }

    }

    @Test
    public void connectedComponents() {
        ConnectedComponents connectedComponents = new ConnectedComponents(graph);
        System.out.println("Count: " + connectedComponents.count());
        System.out.println("Ids: ");
        for (int i = 0; i < graph.getVertices(); i++) {
            System.out.println(connectedComponents.id(i));
        }
        System.out.println("Connected: 0 and 3? " + connectedComponents.connected(0, 3));
        System.out.println("Connected: 0 and 7? " + connectedComponents.connected(0, 7));
        System.out.println("Connected: 0 and 11? " + connectedComponents.connected(0, 11));
    }

}