package zinjvi.algo.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vitalii Zinchenko
 */
public class SubsetsOfSetsTest {

    @Test
    public void test() {
        int[] set = new int[]{1, 2, 3};
        int[][] result = SubsetsOfSets.generate(set);
        int[][] expected = new int[][] {
                {},
                {1},
                {2},
                {1, 2},
                {3},
                {1, 3},
                {2, 3},
                {1, 2, 3},
        };
        Assert.assertArrayEquals(expected, result);
    }

}