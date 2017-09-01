package zinjvi.algo;

/**
 * @author Vitalii Zinchenko
 */
public class Sort extends Loggable {

    public static <T> void selectionSort(T[] array, Comparator<T> comparator) {
        log("Input: array=%s", array);
        for(int i = 0; i < array.length - 1; i++) {
            log("Outer loop: i=%s", i);
            int minIndex = i;
            // find min value
            for (int j = i + 1; j < array.length; j++) {
                if(comparator.compare(array[minIndex], array[j]) > 0) {
                    minIndex = j;
                }
            }
            log("Outer loop: minIndex=%s, minValue=%s", minIndex, array[minIndex]);
            if(i != minIndex) {
                swap(array, i, minIndex);
            }
        }

    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
