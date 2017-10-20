package zinjvi.algo.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Vitalii Zinchenko
 */
public class BinarySearchTreeTest {

    private BinarySearchTreeImpl<Integer, Integer> tree;
    private BinarySearchTreeImpl<Integer, Integer> emptyTree;

    @Before
    public void before() {
        tree = new BinarySearchTreeImpl<>();
        tree.setRoot(
                tree.new Node(5, 105,
                        tree.new Node(4, 104),
                        tree.new Node(6, 106)
                ));

        emptyTree = new BinarySearchTreeImpl<>();
    }

    @Test
    public void search() {
        Integer result = tree.get(6);
        Assert.assertEquals(Integer.valueOf(106), result);
        result = tree.get(5);
        Assert.assertEquals(Integer.valueOf(105), result);
        result = tree.get(4);
        Assert.assertEquals(Integer.valueOf(104), result);
        result = tree.get(7);
        Assert.assertEquals(null, result);
        result = tree.get(3);
        Assert.assertEquals(null, result);
    }

    @Test
    public void insert() {
        BinarySearchTreeImpl<Integer, Integer> expected = new BinarySearchTreeImpl<>();
        expected.setRoot(expected.new Node(1, 10));
        emptyTree.insert(1, 10);
        Assert.assertEquals(expected, emptyTree);


        expected = new BinarySearchTreeImpl<>();
        expected.setRoot(
                expected.new Node(5, 105,
                        expected.new Node(4, 104),
                        expected.new Node(6, 106,
                                null,
                                expected.new Node(10, 110))
                ));
        tree.insert(10, 110);
        Assert.assertEquals(expected, tree);


        expected = new BinarySearchTreeImpl<>();
        expected.setRoot(
                expected.new Node(5, 105,
                        expected.new Node(4, 104),
                        expected.new Node(6, 106,
                                null,
                                expected.new Node(10, 110,
                                        expected.new Node(9, 109),
                                        null))
                ));
        tree.insert(9, 109);
        Assert.assertEquals(expected, tree);


        expected = new BinarySearchTreeImpl<>();
        expected.setRoot(
                expected.new Node(5, 105,
                        expected.new Node(4, 104),
                        expected.new Node(6, 106,
                                null,
                                expected.new Node(10, 110,
                                        expected.new Node(9, 109,
                                                expected.new Node(8, 108),
                                                null),
                                        null))
                ));
        tree.insert(8, 108);
        Assert.assertEquals(expected, tree);


    }

    @Test
    public void min() {
        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<>();
        tree.setRoot(
                tree.new Node(5, 105,
                        tree.new Node(4, 104),
                        tree.new Node(6, 106)
                ));
        Integer min = tree.min();
        Assert.assertEquals((Integer) 4, min);


        tree = new BinarySearchTreeImpl<>();
        tree.setRoot(
                tree.new Node(5, 105
                ));
        min = tree.min();
        Assert.assertEquals((Integer) 5, min);
    }

    @Test
    public void minOfEmpty() {
        Integer min = emptyTree.min();
        Assert.assertNull(min);
    }

    @Test
    public void max() {
        Integer max = tree.max();
        Assert.assertEquals((Integer) 6, max);
    }

    @Test
    public void maxOfNull() {
        Integer max = emptyTree.max();
        Assert.assertNull(max);
    }

    @Test
    public void floorAndCeiling() {
        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<>();
        tree.setRoot(
                tree.new Node(10, 110,
                        tree.new Node(5, 105,
                                tree.new Node(2, 102),
                                tree.new Node(7, 107,
                                        null,
                                        tree.new Node(8, 108,
                                                null,
                                                null))),
                        null
                ));

        // floor

        Integer floor = null;
        floor = tree.floor(6);
        Assert.assertEquals((Integer) 5, floor);


        floor = tree.floor(5);
        Assert.assertEquals((Integer) 5, floor);


        floor = tree.floor(8);
        Assert.assertEquals((Integer) 8, floor);


        floor = tree.floor(9);
        Assert.assertEquals((Integer) 8, floor);


        floor = tree.floor(1);
        Assert.assertEquals(null, floor);


        // ceiling

        Integer ceiling = tree.ceiling(6);
        Assert.assertEquals((Integer) 7, ceiling);

        ceiling = tree.ceiling(1);
        Assert.assertEquals((Integer) 2, ceiling);

        ceiling = tree.ceiling(9);
        Assert.assertEquals((Integer) 10, ceiling);

        ceiling = tree.ceiling(11);
        Assert.assertEquals((Integer) null, ceiling);


        // floor of empty

        tree = new BinarySearchTreeImpl<>();
        floor = tree.ceiling(6);
        Assert.assertEquals(null, floor);


        // ceiling of empty

        tree = new BinarySearchTreeImpl<>();
        ceiling = tree.floor(6);
        Assert.assertEquals(null, ceiling);
    }

    @Test
    public void deleteMin() {
        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<>();
        tree.setRoot(
                tree.new Node(10, 110,
                        null,
                        null
                ));
        tree.deleteMin();
        Assert.assertEquals(new BinarySearchTreeImpl<>(), tree);


        tree = new BinarySearchTreeImpl<>();
        tree.deleteMin();
        Assert.assertEquals(new BinarySearchTreeImpl<>(), tree);


        tree = new BinarySearchTreeImpl<>();
        tree.setRoot(
                tree.new Node(10, 110,
                        tree.new Node(5, 105,
                                tree.new Node(2, 102),
                                tree.new Node(7, 107,
                                        null,
                                        tree.new Node(8, 108,
                                                null,
                                                null))),
                        null
                ));
        tree.deleteMin();
        BinarySearchTreeImpl<Integer, Integer> expected = new BinarySearchTreeImpl<>();
        expected.setRoot(
                expected.new Node(10, 110,
                        expected.new Node(5, 105,
                                null,
                                expected.new Node(7, 107,
                                        null,
                                        expected.new Node(8, 108,
                                                null,
                                                null))),
                        null
                ));
        Assert.assertEquals(expected, tree);


        tree = new BinarySearchTreeImpl<>();
        tree.setRoot(
                tree.new Node(10, 110,
                        tree.new Node(5, 105,
                                null,
                                tree.new Node(7, 107,
                                        null,
                                        tree.new Node(8, 108,
                                                null,
                                                null))),
                        null
                ));
        tree.deleteMin();
        expected = new BinarySearchTreeImpl<>();
        expected.setRoot(
                expected.new Node(10, 110,
                        expected.new Node(7, 107,
                                null,
                                expected.new Node(8, 108,
                                        null,
                                        null)),
                        null
                ));
        Assert.assertEquals(expected, tree);


        tree = new BinarySearchTreeImpl<>();
        tree.setRoot(
                tree.new Node(10, 110,
                        null,
                        tree.new Node(11, 111,
                                null,
                                null
                        )));
        tree.deleteMin();
        expected = new BinarySearchTreeImpl<>();
        expected.setRoot(
                expected.new Node(11, 111,
                        null,
                        null
                ));
        Assert.assertEquals(expected, tree);
    }


    @Test
    public void deleteMax() {
        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<>();
        tree.setRoot(
                tree.new Node(10, 110,
                        null,
                        null
                ));
        tree.deleteMax();
        Assert.assertEquals(new BinarySearchTreeImpl<>(), tree);


        tree = new BinarySearchTreeImpl<>();
        tree.deleteMax();
        Assert.assertEquals(new BinarySearchTreeImpl<>(), tree);


        tree = new BinarySearchTreeImpl<>();
        tree.setRoot(
                tree.new Node(10, 110,
                        tree.new Node(5, 105,
                                tree.new Node(2, 102),
                                tree.new Node(7, 107,
                                        null,
                                        tree.new Node(8, 108,
                                                null,
                                                null))),
                        null
                ));
        tree.deleteMax();
        BinarySearchTreeImpl<Integer, Integer> expected = new BinarySearchTreeImpl<>();
        expected.setRoot(
                tree.new Node(5, 105,
                        tree.new Node(2, 102),
                        tree.new Node(7, 107,
                                null,
                                tree.new Node(8, 108,
                                        null,
                                        null)))
        );
        Assert.assertEquals(expected, tree);


        tree = new BinarySearchTreeImpl<>();
        tree.setRoot(
                tree.new Node(5, 105,
                        tree.new Node(2, 102),
                        tree.new Node(7, 107,
                                null,
                                tree.new Node(8, 108,
                                        null,
                                        null)))
        );
        tree.deleteMax();
        expected = new BinarySearchTreeImpl<>();
        expected.setRoot(
                tree.new Node(5, 105,
                        tree.new Node(2, 102),
                        tree.new Node(7, 107,
                                null,
                                null))
        );
        Assert.assertEquals(expected, tree);
    }


    @Test
    public void delete() {
        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<>();
        BinarySearchTreeImpl<Integer, Integer> expected = new BinarySearchTreeImpl<>();

        tree.setRoot(
                tree.new Node(10, 110,
                        null,
                        null
                ));
        tree.delete(10);
        Assert.assertEquals(new BinarySearchTreeImpl<>(), tree);


        tree = new BinarySearchTreeImpl<>();
        tree.deleteMax();
        Assert.assertEquals(new BinarySearchTreeImpl<>(), tree);


        tree = new BinarySearchTreeImpl<>();
        tree.setRoot(
                tree.new Node(10, 110,
                        tree.new Node(5, 105,
                                null,
                                null
                        ),
                        null
                )
        );
        tree.delete(10);
        expected = new BinarySearchTreeImpl<>();
        expected.setRoot(
                tree.new Node(5, 105,
                        null,
                        null
                )
        );
        Assert.assertEquals(expected, tree);


        tree = new BinarySearchTreeImpl<>();
        tree.setRoot(
                tree.new Node(10, 110,
                        null,
                        tree.new Node(11, 111,
                                null,
                                null
                        )
                )
        );
        tree.delete(10);
        expected = new BinarySearchTreeImpl<>();
        expected.setRoot(
                tree.new Node(11, 111,
                        null,
                        null
                )
        );
        Assert.assertEquals(expected, tree);


        tree = new BinarySearchTreeImpl<>();
        tree.setRoot(
                tree.new Node(10, 110,
                        tree.new Node(5, 105,
                                tree.new Node(2, 102),
                                tree.new Node(7, 107,
                                        tree.new Node(6, 106,
                                                null,
                                                null),
                                        tree.new Node(8, 108,
                                                null,
                                                null)
                                )
                        ),
                        null
                )
        );
        tree.delete(5);
        expected = new BinarySearchTreeImpl<>();
        expected.setRoot(
                tree.new Node(10, 110,
                        tree.new Node(6, 106,
                                tree.new Node(2, 102),
                                tree.new Node(7, 107,
                                        null,
                                        tree.new Node(8, 108,
                                                null,
                                                null)
                                )
                        ),
                        null
                )
        );
        Assert.assertEquals(expected, tree);


        tree = new BinarySearchTreeImpl<>();
        tree.setRoot(
                tree.new Node(10, 110,
                        tree.new Node(5, 105,
                                tree.new Node(2, 102),
                                tree.new Node(7, 107,
                                        null,
                                        tree.new Node(8, 108,
                                                null,
                                                null)
                                )
                        ),
                        null
                )
        );
        tree.delete(5);
        expected = new BinarySearchTreeImpl<>();
        expected.setRoot(
                tree.new Node(10, 110,
                        tree.new Node(7, 107,
                                tree.new Node(2, 102),
                                tree.new Node(8, 108,
                                        null,
                                        null
                                )
                        ),
                        null
                )
        );
        Assert.assertEquals(expected, tree);


        tree = new BinarySearchTreeImpl<>();
        tree.setRoot(
                tree.new Node(10, 110,
                        tree.new Node(5, 105,
                                tree.new Node(2, 102),
                                tree.new Node(7, 107,
                                        null,
                                        null
                                )
                        ),
                        null
                )
        );
        tree.delete(5);
        expected = new BinarySearchTreeImpl<>();
        expected.setRoot(
                tree.new Node(10, 110,
                        tree.new Node(7, 107,
                                tree.new Node(2, 102),
                                null
                        ),
                        null
                )
        );
        Assert.assertEquals(expected, tree);
    }


}