package zinjvi.algo;

/**
 * @author Vitalii Zinchenko
 */
public class PriorityQueue<K> {

    private int size;
    private Object[] array;

    public PriorityQueue(int initSize) {
        this.array = new Object[initSize];
    }

    public K[] getArray() {
        return (K[]) array;
    }

    public void put(K key) {
        resizeIfNeeded();
        array[size] = key;
        size++;
        bottomUpReheapify();
    }

    // swim
    private void bottomUpReheapify() {
        int currentIndex = size - 1;
        while (currentIndex > 0) {
            int parent;
            if (currentIndex % 2 == 1) parent = currentIndex / 2;
            else parent = (currentIndex / 2) - 1;

            if (less(parent, currentIndex)) swap(parent, currentIndex);
            else break;

            currentIndex = parent;
        }
    }

    private boolean less(int aIndex, int bIndex) {
        Comparable<K> a = (Comparable<K>) array[aIndex];
        return a.compareTo((K) array[bIndex]) < 0;
    }

    private void resizeIfNeeded() {
        if (array.length == size) {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            this.array = newArray;
        }
    }

    private void swap(int aIndex, int bIndex) {
        Object a = array[aIndex];
        array[aIndex] = array[bIndex];
        array[bIndex] = a;
    }

    public K get() {
        Object root = array[0];
        array[0] = array[size - 1];
        array[size - 1] = null;
        size--;
        topDownReheapify();
        return (K) root;
    }

    // sink
    private void topDownReheapify() {
        int rootIndex = 0;
        int index;
        while ((index = rootIndex * 2 + 1) < size) {
            if (index + 1 < size && less(index, index + 1)) index ++;
            if (less(index, rootIndex)) break;

            swap(index, rootIndex);
            rootIndex = index;
        }
    }

}