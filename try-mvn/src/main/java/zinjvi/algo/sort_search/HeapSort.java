package zinjvi.algo.sort_search;

/**
 * @author Vitalii Zinchenko
 */
public class HeapSort {
    public static <T> void sort(T[] array, Comparator<T> comparator) {
        makeHeap(array, comparator);
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            reheapify(array, 0, i - 1, comparator);
        }
    }

    private static  <T> void makeHeap(T[] array, Comparator<T> comparator) {
        for (int i = array.length/2 - 1; i >= 0; i--) {
            reheapify(array, i, array.length, comparator);
        }
    }

    private static <T> void reheapify(T[] array, int root, int n, Comparator<T> comparator) {
        int currentRoot = root;
        int index;
        while ((index = currentRoot * 2 + 1) < n) {
            if (index + 1 < n && less(array[index], array[index + 1], comparator)) index++;
            if (less(array[currentRoot], array[index], comparator)) swap(array, index, currentRoot);

            currentRoot = index;
        }
    }

    private static <T> boolean less(T a, T b, Comparator<T> comparator) {
        return comparator.compare(a, b) < 0;
    }

    private static <T> void swap(T[] array, int aIndex, int bIndex) {
        T a = array[aIndex];
        array[aIndex] = array[bIndex];
        array[bIndex] = a;
    }
}
