package zinjvi.algo.sort_search;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vitalii Zinchenko
 */
public class BinarySearch {

    private static final Comparator<Integer> INTEGER_COMPARATOR = Integer::compareTo;
    public static final Integer[] ARRAY = {1, 3, 5, 6, 8, 10, 15, 16, 17, 19};

    @Test
    public void test() {
        int result = Search.binary(ARRAY, 3, INTEGER_COMPARATOR);
        Assert.assertEquals(1, result);
    }
    @Test
    public void test2() {
        int result = Search.binary(ARRAY, 19, INTEGER_COMPARATOR);
        Assert.assertEquals(9, result);
    }

    @Test
    public void notFound_outOfTheRange() {
        int result = Search.binary(ARRAY, 20, INTEGER_COMPARATOR);
        Assert.assertEquals(-1, result);
    }

    @Test
    public void notFound_insideTheRange() {
        int result = Search.binary(ARRAY, 18, INTEGER_COMPARATOR);
        Assert.assertEquals(-1, result);
    }

}
