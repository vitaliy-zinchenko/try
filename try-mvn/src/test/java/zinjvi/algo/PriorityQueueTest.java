package zinjvi.algo;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vitalii Zinchenko
 */
public class PriorityQueueTest {

    @Test
    public void test() {
        PriorityQueue<Integer> queue = new PriorityQueue<>(10);
        Integer[] expectedArray = new Integer[10];

        queue.put(100);
        expectedArray[0] = 100;
        Assert.assertArrayEquals(queue.getArray(), expectedArray);

        queue.put(50);
        expectedArray[0] = 100;
        expectedArray[1] = 50;
        Assert.assertArrayEquals(queue.getArray(), expectedArray);

        queue.put(200);
        expectedArray[0] = 200;
        expectedArray[1] = 50;
        expectedArray[2] = 100;
        Assert.assertArrayEquals(queue.getArray(), expectedArray);

        queue.put(75);
        expectedArray[0] = 200;
        expectedArray[1] = 75;
        expectedArray[2] = 100;
        expectedArray[3] = 50;
        Assert.assertArrayEquals(queue.getArray(), expectedArray);
    }

    @Test
    public void resize() {
        PriorityQueue<Integer> queue = new PriorityQueue<>(1);

        Integer[] expected = new Integer[1];
        Assert.assertArrayEquals(expected, queue.getArray());

        queue.put(200);
        expected = new Integer[]{200};
        Assert.assertArrayEquals(expected, queue.getArray());

        queue.put(100);
        expected = new Integer[] {200, 100};
        Assert.assertArrayEquals(expected, queue.getArray());
    }

    @Test
    public void get() {
        PriorityQueue<Integer> queue = new PriorityQueue<>(7);
        queue.put(200);
        queue.put(50);
        queue.put(100);
        queue.put(10);
        queue.put(20);
        queue.put(50);
        queue.put(40);

        Integer max = queue.get();
        Integer maxExpected = 200;
        Integer[] expected = new Integer[]{100, 50, 50, 10, 20, 40, null};
        Assert.assertEquals(maxExpected, max);
        Assert.assertArrayEquals(expected, queue.getArray());

        max = queue.get();
        maxExpected = 100;
        expected = new Integer[]{50, 40, 50, 10, 20, null, null};
        Assert.assertEquals(maxExpected, max);
        Assert.assertArrayEquals(expected, queue.getArray());

        max = queue.get();
        maxExpected = 50;
        expected = new Integer[]{50, 40, 20, 10, null, null, null};
        Assert.assertEquals(maxExpected, max);
        Assert.assertArrayEquals(expected, queue.getArray());

        max = queue.get();
        maxExpected = 50;
        expected = new Integer[]{40, 10, 20, null, null, null, null};
        Assert.assertEquals(maxExpected, max);
        Assert.assertArrayEquals(expected, queue.getArray());

        max = queue.get();
        maxExpected = 40;
        expected = new Integer[]{20, 10, null, null, null, null, null};
        Assert.assertEquals(maxExpected, max);
        Assert.assertArrayEquals(expected, queue.getArray());

        max = queue.get();
        maxExpected = 20;
        expected = new Integer[]{10, null, null, null, null, null, null};
        Assert.assertEquals(maxExpected, max);
        Assert.assertArrayEquals(expected, queue.getArray());

        max = queue.get();
        maxExpected = 10;
        expected = new Integer[]{null, null, null, null, null, null, null};
        Assert.assertEquals(maxExpected, max);
        Assert.assertArrayEquals(expected, queue.getArray());
    }

}