package zinjvi.algo.tree;

/**
 * @author Vitalii Zinchenko
 */
public interface BinarySearchTree <K extends Comparable<K>, V> {

    V get(K key);

    void insert(K key, V value);

    K min();

    K max();

    K floor(K key);

    K ceiling(K key);

    void deleteMin();

    void deleteMax();

    void delete(K key);

}
