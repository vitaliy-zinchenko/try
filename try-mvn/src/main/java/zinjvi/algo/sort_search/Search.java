package zinjvi.algo.sort_search;

/**
 * @author Vitalii Zinchenko
 */
public final class Search extends Loggable {

    private Search() {
    }

    /**
     *
     * 0 1 . . . . . . . . i . . . n
     *       l       r                  - continue
     *       lr                         - continue
     *      (lr) - in one cell          - continue
     *    r       l                     - finish
     *
     * finish if: r > l
     *
     * @param array sorted array
     * @param comparator
     * @param item
     * @param <T>
     * @return the index of the item
     */
    public static <T> int binary(T[] array, T item, Comparator<T> comparator) {
        log("Is looking for: %s", item);
        int result = -1;
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            log("Loop...");
            int center = (right + left) / 2;
            log("Left: %s(%s), Center: %s(%s), Right: %s(%s)", left, array[left], center, array[center], right, array[right]);
            T centerItem = array[center];
            // compare could be:
            //   - negative   =>   centerItem <  item   =>  new range: center-right
            //   - zero       =>   centerItem == item   =>  result
            //   - positive   =>   centerItem >  item   =>  new range: right-center
            int compare = comparator.compare(centerItem, item);
            if(compare < 0) {
                left = center + 1;
                log("Choose right side.");
            } else if(compare > 0) {
                right = center - 1;
                log("Choose left side.");
            } else {
                result = center;
                log("Found! [%s]", result);
                break;
            }
            log("Left: %s, Right: %s", left, right);
        }
        return result;
    }

}
