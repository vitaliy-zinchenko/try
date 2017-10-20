package zinjvi.algo.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vitalii Zinchenko
 */
public class AvlTreeTest {

    @Test
    public void insert_toEmpty() {
        // given
        AvlTree<Integer> tree = new AvlTree<>();
        // when
        tree.insert(10);
        // then
        AvlTree<Integer> expected = new AvlTree<>();
        expected.setRoot(expected.new Node(10));
        Assert.assertEquals(expected, tree);
    }

    @Test
    public void insert_oneNodeTree() {
        // given
        AvlTree<Integer> tree = new AvlTree<>();
        tree.setRoot(tree.new Node(10));
        // when
        tree.insert(5);
        // then
        AvlTree<Integer> expected = new AvlTree<>();
        expected.setRoot(expected.new Node(10, 1,
                expected.new Node(5),
                null));
        Assert.assertEquals(expected, tree);
    }

    @Test
    public void insert_rightRotation() {
        // given
        AvlTree<Integer> tree = new AvlTree<>();
        tree.setRoot(
                tree.new Node(10, 1,
                        tree.new Node(5),
                        null));
        // when
        tree.insert(1);
        // then
        AvlTree<Integer> expected = new AvlTree<>();
        expected.setRoot(expected.new Node(5, 1,
                expected.new Node(1),
                expected.new Node(10)));
        Assert.assertEquals(expected, tree);
    }

    @Test
    public void insert_leftRotation() {
        // given
        AvlTree<Integer> tree = new AvlTree<>();
        tree.setRoot(
                tree.new Node(10, 1,
                        null,
                        tree.new Node(15)
                )
        );
        // when
        tree.insert(20);
        // then
        AvlTree<Integer> expected = new AvlTree<>();
        expected.setRoot(expected.new Node(15, 1,
                expected.new Node(10),
                expected.new Node(20)));
        Assert.assertEquals(expected, tree);
    }

    @Test
    public void insert_leftRightRotation() {
        // given
        AvlTree<Integer> tree = new AvlTree<>();
        tree.setRoot(
                tree.new Node(10, 2,
                        tree.new Node(5),
                        null));
        // when
        tree.insert(6);
        // then
        AvlTree<Integer> expected = new AvlTree<>();
        expected.setRoot(expected.new Node(6, 1,
                expected.new Node(5),
                expected.new Node(10)));
        Assert.assertEquals(expected, tree);
    }

    @Test
    public void insert_rightLeftRotation() {
        // given
        AvlTree<Integer> tree = new AvlTree<>();
        tree.setRoot(
                tree.new Node(10, 2,
                        null,
                        tree.new Node(15)
                )
        );
        // when
        tree.insert(12);
        // then
        AvlTree<Integer> expected = new AvlTree<>();
        expected.setRoot(expected.new Node(12, 1,
                expected.new Node(10),
                expected.new Node(15)));
        Assert.assertEquals(expected, tree);
    }

    @Test
    public void insert() {
        // given
        AvlTree<Integer> tree = new AvlTree<>();

        // when
        tree.insert(3);
        // then
        AvlTree<Integer> expected = new AvlTree<>();
        expected.setRoot(expected.new Node(3));
        Assert.assertEquals(expected, tree);

        // when
        tree.insert(2);
        // then
        expected = new AvlTree<>();
        expected.setRoot(expected.new Node(3, 1,
                        expected.new Node(2),
                        null
                )
        );
        Assert.assertEquals(expected, tree);

        // when
        tree.insert(1);
        // then
        expected = new AvlTree<>();
        expected.setRoot(expected.new Node(2, 1,
                        expected.new Node(1),
                        expected.new Node(3)
                )
        );
        Assert.assertEquals(expected, tree);

        // when
        tree.insert(4);
        // then
        expected = new AvlTree<>();
        expected.setRoot(expected.new Node(2, 2,
                        expected.new Node(1),
                        expected.new Node(3, 1,
                                null,
                                expected.new Node(4)
                        )
                )
        );
        Assert.assertEquals(expected, tree);

        // when
        tree.insert(5);
        // then
        expected = new AvlTree<>();
        expected.setRoot(expected.new Node(2, 2,
                        expected.new Node(1),
                        expected.new Node(4, 1,
                                expected.new Node(3),
                                expected.new Node(5)
                        )
                )
        );
        Assert.assertEquals(expected, tree);

        // when
        tree.insert(6);
        // then
        expected = new AvlTree<>();
        expected.setRoot(expected.new Node(4, 2,
                        expected.new Node(2, 1,
                                expected.new Node(1),
                                expected.new Node(3)
                        ),
                        expected.new Node(5, 1,
                                null,
                                expected.new Node(6)
                        )
                )
        );
        Assert.assertEquals(expected, tree);

        // when
        tree.insert(7);
        // then
        expected = new AvlTree<>();
        expected.setRoot(expected.new Node(4, 2,
                        expected.new Node(2, 1,
                                expected.new Node(1),
                                expected.new Node(3)
                        ),
                        expected.new Node(6, 1,
                                expected.new Node(5),
                                expected.new Node(7)
                        )
                )
        );
        Assert.assertEquals(expected, tree);
    }

}