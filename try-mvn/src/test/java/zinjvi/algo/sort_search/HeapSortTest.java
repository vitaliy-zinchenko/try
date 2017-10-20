package zinjvi.algo.sort_search;

import org.junit.Test;

/**
 * @author Vitalii Zinchenko
 */
public class HeapSortTest {

    @Test
    public void test() {
        Integer[] array = new Integer[]{10, 200, 20, 50, 500, 300, 400, 70};
        HeapSort.sort(array, SortTest.INTEGER_COMPARATOR);
        Integer[] expected = new Integer[]{10, 20, 50, 70 , 200, 300, 400, 500};

    }

}