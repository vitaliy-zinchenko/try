package zinjvi.algo.sort_search;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vitalii Zinchenko
 */
public class SortTest {

    public static final Comparator<Integer> INTEGER_COMPARATOR = Integer::compareTo;

    @Test
    public void test() {
        Integer[] array = new Integer[]{3, 2, 1};
        Sort.selectionSort(array, INTEGER_COMPARATOR);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3}, array);
    }

    @Test
    public void test2() {
        Integer[] array = new Integer[]{1, 2, 3};
        Sort.selectionSort(array, INTEGER_COMPARATOR);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3}, array);
    }

    @Test
    public void test3() {
        Integer[] array = new Integer[]{1, 3, 2, 6, 5, 7};
        Sort.selectionSort(array, INTEGER_COMPARATOR);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 5, 6, 7}, array);
    }

    @Test
    public void insertionTest() {
        Integer[] array = new Integer[]{3, 2, 1};
        Sort.insertionSort(array, INTEGER_COMPARATOR);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3}, array);
    }

    @Test
    public void insertionTest2() {
        Integer[] array = new Integer[]{1, 2, 3};
        Sort.insertionSort(array, INTEGER_COMPARATOR);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3}, array);
    }

    @Test
    public void insertionTest3() {
        Integer[] array = new Integer[]{1, 3, 2, 6, 5, 7};
        Sort.insertionSort(array, INTEGER_COMPARATOR);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 5, 6, 7}, array);
    }

    @Test
    public void mergeTest() {
        Integer[] array = new Integer[]{1, 3, 5, 2, 4, 6};
        Sort.merge(array, INTEGER_COMPARATOR, 0, 2, 5);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, array);
    }

    @Test
    public void mergeTest2() {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6};
        Sort.merge(array, INTEGER_COMPARATOR, 0, 2, 5);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, array);
    }

    @Test
    public void mergeTest3() {
        Integer[] array = new Integer[]{4, 5, 6, 1, 2, 3};
        Sort.merge(array, INTEGER_COMPARATOR, 0, 2, 5);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, array);
    }

    @Test
    public void mergeTest4() {
        Integer[] array = new Integer[]{1, 2, 4, 3, 5, 6};
        Sort.merge(array, INTEGER_COMPARATOR, 0, 2, 5);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, array);
    }

    @Test
    public void mergeSortTest() {
        Integer[] array = new Integer[]{3, 2, 5, 1, 6, 4};
        Sort.mergeSort(array, INTEGER_COMPARATOR);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, array);
    }

    @Test
    public void partitionTest() {
        Integer[] array = new Integer[]{3, 2, 7, 8, 5, 1, 6, 4};
        int partition = Sort.partition(array, INTEGER_COMPARATOR, 1, 6);
        Assert.assertEquals(4, partition);
        Assert.assertArrayEquals(new Integer[]{3, 2, 5, 1, 6, 8, 7, 4}, array);
    }

    @Test
    public void partitionTest2() {
        Integer[] array = new Integer[]{1, 2, 3};
        int partition = Sort.partition(array, INTEGER_COMPARATOR, 0, 2);
        Assert.assertEquals(2, partition);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3}, array);
    }

    @Test
    public void quickSortTest() {
        Integer[] array = new Integer[]{3, 2, 7, 8, 5, 1, 6, 4};
        Sort.quickSort(array, INTEGER_COMPARATOR);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}, array);
    }

    @Test
    public void count() {
        int[] array = new int[] {4, 2, 1, 0, 0, 1, 4, 2, 1 ,3};
        int[] count = Sort.count(array);
        Assert.assertArrayEquals(new int[]{2, 3, 2, 1, 2}, count);
    }

    @Test
    public void countEmpty() {
        int[] array = new int[] {};
        int[] count = Sort.count(array);
        Assert.assertEquals(0, count.length);
        Assert.assertArrayEquals(new int[]{}, count);
    }

    @Test
    public void last() {
        int[] count = new int[] {2, 3, 2, 1, 2};
        int[] last = Sort.last(count);
        Assert.assertArrayEquals(new int[]{1, 4, 6, 7, 9}, last);
    }

    @Test
    public void next() {
        int[] last = new int[] {1, 4, 6, 7, 9};
        int[] next = Sort.next(last);
        Assert.assertArrayEquals(new int[]{0, 2, 5, 7, 8}, next);
    }

    @Test
    public void countSearch() {
        int[] array = new int[] {4, 2, 1, 0, 0, 1, 4, 2, 1 ,3};
        int[] result = Sort.countSort(array);
        Assert.assertArrayEquals(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 4, 4}, result);
    }



}
