package zinjvi.algo.tree;

import org.junit.Test;

/**
 * @author Vitalii Zinchenko
 */
public class B23TreeTest {

    @Test
    public void insert_toEmpty() {
        // given
        B23Tree<Integer> tree = new B23Tree<>();

        // when
        tree.insert(100);

        // then
        B23Tree<Integer> expected = new B23Tree<>();
        expected.setRoot(
                expected.new Node(100)
        );
    }

    @Test
    public void insert_toOneNodeTree_greater() {
        // given
        B23Tree<Integer> tree = new B23Tree<>();
        tree.setRoot(
                tree.new Node(100)
        );

        // when
        tree.insert(200);

        // then
        B23Tree<Integer> expected = new B23Tree<>();
        expected.setRoot(
                expected.new Node(100, 200)
        );
    }

}