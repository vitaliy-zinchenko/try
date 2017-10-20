package zinjvi.algo.misc;

/**
 * @author Vitalii Zinchenko
 */
public class SubsetsOfSets {

    public static int[][] generate(int[] set) {
        int resultCount = Double.valueOf(Math.pow(2, set.length)).intValue();
        int[][] result = new int[resultCount][];
        for (int i = 0; i < resultCount; i++) {
            int subsetLength = Integer.bitCount(i);
            int[] subset = new int[subsetLength];
            int nextSubsetItem = 0;
            // Converting binary "i" representation to sub set.
            // Only item with "1" in binary representation will be taken from set argument
            // for example:
            // having: set = {a, b, c} and i = 2 = {0, 1, 0}, the subset {b} will be added to result
            for (int j = 0; j < set.length; j++) {
                if ((i & (1 << j)) > 0) {
                    subset[nextSubsetItem] = set[j];
                    nextSubsetItem++;
                }
            }
            result[i] = subset;
        }
        return result;
    }

}
