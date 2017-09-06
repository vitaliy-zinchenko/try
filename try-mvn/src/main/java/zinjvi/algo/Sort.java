package zinjvi.algo;

import java.util.Arrays;

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

    public static <T> void insertionSort(T[] array, Comparator<T> comparator) {
        for(int i=1; i < array.length; i++) {
            for(int j=i; j > 0; j--) {
                int prev = j - 1;
                if(comparator.compare(array[prev], array[j]) > 0) {
                    swap(array, prev, j);
                } else {
                    break;
                }
            }
        }
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T> void mergeSort(T[] array, Comparator<T> comparator) {
        int left = 0;
        int right = array.length - 1;
        doMergeSort(array, comparator, left, right);
    }

    private static <T> void doMergeSort(T[] array, Comparator<T> comparator, int left, int right) {
        log("doMergeSort(%s, %d, %d)", Arrays.toString(array), left, right);
        if(left == right) { // TODO what is better?
            return;
        }
        int center = (left + right) / 2;
        doMergeSort(array, comparator, left, center);
        doMergeSort(array, comparator, center + 1, right);
        merge(array, comparator, left, center, right);
    }

    public static <T> void merge(T[] array, Comparator<T> comparator, int left, int center, int right) {
        T[] leftArray = createArray(array, left, center - left + 1);
        T[] rightArray = createArray(array, center + 1, right - center);
        for(int i = left, leftPos = 0, rightPos = 0; i <= right ; i++) {
            if(leftPos == leftArray.length) { // TODO refactor
                array[i] = rightArray[rightPos];
                rightPos++;
            } else if(rightPos == rightArray.length) {
                array[i] = leftArray[leftPos];
                leftPos++;
            } else if(comparator.compare(leftArray[leftPos], rightArray[rightPos]) < 0) {
                array[i] = leftArray[leftPos];
                leftPos++;
            } else {
                array[i] = rightArray[rightPos];
                rightPos++;
            }
        }
        log("merged: %s, %d, %d, %d", Arrays.toString(array), left, center, right);
    }

    private static <T> T[] createArray(T[] src, int srcStart, int length) {
        T[] array = (T[]) new Object[length];
        System.arraycopy(src, srcStart, array, 0, length);
        return array;
    }
}
