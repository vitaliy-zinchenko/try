package zinjvi.algo;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vitalii Zinchenko
 */
public class SortTest {

    private static final Comparator<Integer> INTEGER_COMPARATOR = Integer::compareTo;

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
    public void mergeSortTest() {
        Integer[] array = new Integer[]{3, 2, 5, 1, 6, 4};
        Sort.mergeSort(array, INTEGER_COMPARATOR);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, array);
    }

}
