package zinjvi.algo;

/**
 * @author Vitalii Zinchenko
 */
public interface Comparator<T> {
    /**
     *
     * @param first
     * @param second
     * @return a negative integer, zero, or a positive integer as the
     *         first argument is less than, equal to, or greater than the second.
     */
    int compare(T first, T second);
}
