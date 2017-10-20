package zinjvi.algo.tree;

/**
 * @author Vitalii Zinchenko
 */
public class BinarySearchTreeImpl<K extends Comparable<K>, V> implements BinarySearchTree<K, V> {

    private Node root;

    public final class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;

        public Node(K key, V value) {
            this(key, value, null, null);
        }

        protected Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Node that = (Node) obj;

            if (key != null && !key.equals(that.key)) return false;
            else if (key == null && that.key != null) return false;

            if (value != null && !value.equals(that.value)) return false;
            else if (value == null && that.value != null) return false;

            if (left != null && !left.equals(that.left)) return false;
            else if (left == null && that.left != null) return false;

            if (right != null && !right.equals(that.right)) return false;
            else if (right == null && that.right != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    protected BinarySearchTreeImpl setRoot(Node node) {
        this.root = node;
        return this;
    }

    @Override
    public V get(K key) {
        Node node = search(root, key);
        return node == null ? null : node.value;
    }

    private Node search(Node node, K key) {
        if (node == null) return null;

        int compare = key.compareTo(node.key);
        if (compare < 0) return search(node.left, key);
        if (compare > 0) return search(node.right, key);
        else return node;
    }

    @Override
    public void insert(K key, V value) {
        if (key == null) throw new NullPointerException();
        root = insert(root, key, value);
    }

    @Override
    public K min() {
        if (root == null) return null;
        Node min = min(root);
        return min == null ? null : min.key;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        else return min(node.left);
    }

//    public Key min()
//    {
//        return min(root).key;
//    }
//    private Node min(Node x)
//    {
//        if (x.left == null) return x;
//        return min(x.left);
//    }

    @Override
    public K max() {
        return root == null ? null : max(root);
    }

    @Override
    public K floor(K key) {
        if (key == null) throw new NullPointerException();
        return floor(key, root);
    }

    private K floor(K key, Node node) {
        if (node == null) return null;

        int compare = key.compareTo(node.key);
        if (compare == 0) return node.key;
        if (compare < 0) return floor(key, node.left);
        K rightFloor = floor(key, node.right);
        return rightFloor == null ? node.key : rightFloor;
    }

    @Override
    public K ceiling(K key) {
        return ceiling(key, root);
    }

    @Override
    public void deleteMin() {
        if (root == null) return;
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        } else {
            node.left = deleteMin(node.left);
            return node;
        }
    }

    @Override
    public void deleteMax() {
        if (root == null) return;
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if (node.right == null) {
            return node.left;
        } else {
            node.right = deleteMax(node.right);
            return node;
        }
    }

    @Override
    public void delete(K key) {
        if (root == null) return;
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null) return null;
        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.left = delete(node.left, key);
            return node;
        }
        if (compare > 0) {
            node.right = delete(node.right, key);
            return node;
        }

        if (node.right == null) return node.left;  // ?
        if (node.left == null) return node.right; // ?

        Node minNode = min(node.right);
        minNode.right = deleteMin(node.right);
        minNode.left = node.left;

        return minNode;
    }

//    private Node getAndRemoveMin(Node removeNode) {
//        re
//    }
//
//    private Node getAndRemoveMin(Node node, Node parent) {
//        if (node.left == null) {
//            parent.left = node.right;
//            return node;
//        }
//        return getAndRemoveMin(node.left, node);
//    }

//    private void swapToLeft(Node node, Node parent) {
//        if (parent != null) {
//            if (node.right == null)
//        }
//    }

    private K ceiling(K key, Node node) {
        if (node == null) return null;

        int compare = key.compareTo(node.key);
        if (compare == 0) return key;
        else if (compare > 0) return ceiling(key, node.right);
        K leftCeiling = ceiling(key, node.left);
        return leftCeiling == null ? node.key : leftCeiling;
    }

    private K max(Node node) {
        if (node.right == null) return node.key;
        else return max(node.right);
    }

    private Node insert(Node node, K key, V value) {
        if (node == null) return new Node(key, value);

        int compare = key.compareTo(node.key);

        if (compare < 0) node.left = insert(node.left, key, value);
        else if (compare > 0) node.right = insert(node.right, key, value);
        else node.value = value;

        return node;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        BinarySearchTreeImpl<?, ?> that = (BinarySearchTreeImpl<?, ?>) obj;

        return this.root != null ? this.root.equals(that.root) : that.root == null;
    }

    @Override
    public int hashCode() {
        return root != null ? root.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BinarySearchTreeImpl{" +
                "root=" + root +
                '}';
    }
}
