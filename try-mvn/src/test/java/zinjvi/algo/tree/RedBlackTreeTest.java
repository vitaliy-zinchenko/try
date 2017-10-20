package zinjvi.algo.tree;

import org.junit.Assert;
import org.junit.Test;

import static zinjvi.algo.tree.RedBlackTree.BLACK;
import static zinjvi.algo.tree.RedBlackTree.RED;

/**
 * @author Vitalii Zinchenko
 */
public class RedBlackTreeTest {

    @Test
    public void add_toEmpty() {
        // given
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        // when
        tree.add(100);
        // then
        RedBlackTree<Integer> expected = new RedBlackTree<>();
        expected.setRoot(expected.new Node(100, BLACK));
        Assert.assertEquals(expected, tree);
    }

    @Test
    public void add_toOneNodeTree_greater() {
        // given
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.setRoot(tree.new Node(100, BLACK));
        // when
        tree.add(200);
        // then
        RedBlackTree<Integer> expected = new RedBlackTree<>();
        expected.setRoot(expected.new Node(200, BLACK,
                        expected.new Node(100, RED),
                        null
                )
        );
        Assert.assertEquals(expected, tree);
    }

    @Test
    public void add_toOneNodeTree_smaller() {
        // given
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.setRoot(tree.new Node(100, BLACK));
        // when
        tree.add(50);
        // then
        RedBlackTree<Integer> expected = new RedBlackTree<>();
        expected.setRoot(expected.new Node(100, BLACK,
                        expected.new Node(50, RED),
                        null
                )
        );
        Assert.assertEquals(expected, tree);
    }

    @Test
    public void add_twoRedChildren() {
        // given
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.setRoot(tree.new Node(200, BLACK,
                tree.new Node(100, RED),
                null)
        );
        // when
        tree.add(300);
        // then
        RedBlackTree<Integer> expected = new RedBlackTree<>();
        expected.setRoot(expected.new Node(200, BLACK,
                        expected.new Node(100, BLACK),
                        expected.new Node(300, BLACK)
                )
        );
        Assert.assertEquals(expected, tree);
    }

    @Test
    public void add_leftIsRedAndLeftLeftIsRed() {
        // given
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.setRoot(tree.new Node(200, BLACK,
                tree.new Node(100, RED),
                null)
        );
        // when
        tree.add(50);
        // then
        RedBlackTree<Integer> expected = new RedBlackTree<>();
        expected.setRoot(expected.new Node(100, BLACK,
                        expected.new Node(50, BLACK),
                        expected.new Node(200, BLACK)
                )
        );
        Assert.assertEquals(expected, tree);
    }

    @Test
    public void add_leftIsRedAndLeftRightIsRed() {
        // given
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.setRoot(tree.new Node(200, BLACK,
                tree.new Node(100, RED),
                null)
        );
        // when
        tree.add(150);
        // then
        RedBlackTree<Integer> expected = new RedBlackTree<>();
        expected.setRoot(expected.new Node(150, BLACK,
                        expected.new Node(100, BLACK),
                        expected.new Node(200, BLACK)
                )
        );
        Assert.assertEquals(expected, tree);
    }

}