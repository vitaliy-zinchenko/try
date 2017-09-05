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

}
