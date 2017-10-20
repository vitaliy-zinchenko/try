package zinjvi.algo.tree;

/**
 * @author Vitalii Zinchenko
 */
public class RedBlackTree<K extends Comparable> {

    public static final boolean RED = true;
    public static final boolean BLACK = false;

    private Node root;

    public class Node {
        private K key;
        private Node left;
        private Node right;
        private boolean color;

        public Node(K key, boolean color) {
            this.key = key;
            this.color = color;
        }

        public Node(K key, boolean red, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.color = red;
        }

        public boolean isRed() {
            return color;
        }

        public boolean isBlack() {
            return !color;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (color != node.color) return false;
            if (key != null ? !key.equals(node.key) : node.key != null) return false;
            if (left != null ? !left.equals(node.left) : node.left != null) return false;
            return right != null ? right.equals(node.right) : node.right == null;
        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (left != null ? left.hashCode() : 0);
            result = 31 * result + (right != null ? right.hashCode() : 0);
            result = 31 * result + (color ? 1 : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", left=" + left +
                    ", right=" + right +
                    ", color=" + getColorString(color) +
                    '}';
        }

        private String getColorString(boolean color) {
            return color == RED ? "RED" : "BLACK";
        }
    }

    public void add(K key) {
        this.root = add(this.root, key);
        root.color = BLACK;
    }

    private Node add(Node node, K key) {
        if(node == null) return new Node(key, RED);

        int compare = key.compareTo(node.key);
        if(compare < 0) node.left = add(node.left, key);
        else if (compare > 0) node.right = add(node.right, key);
        else return node;

        Node newRoot = node;

        if (isBlack(newRoot.left) && isRed(newRoot.right)) newRoot = rotateLeft(newRoot);
        if (isRed(newRoot.left) && isRed(newRoot.left.left)) newRoot = rotateRight(newRoot);
        if (isRed(newRoot.left) && isRed(newRoot.right)) makeChildrenBlack(newRoot);
        return newRoot;
    }

    private Node rotateLeft(Node node) {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        newRoot.color = node.color;
        node.color = RED;
        return newRoot;
    }

    private Node rotateRight(Node node) {
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        newRoot.color = node.color;
        node.color = RED;
        return newRoot;
    }

    private boolean isBlack(Node node) {
        return node == null || node.isBlack();
    }

    private boolean isRed(Node node) {
        return node != null && node.isRed();
    }

    private void makeChildrenBlack(Node node) {
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RedBlackTree<?> that = (RedBlackTree<?>) o;

        return root != null ? root.equals(that.root) : that.root == null;
    }

    @Override
    public int hashCode() {
        return root != null ? root.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "RedBlackTree{" +
                "root=" + root +
                '}';
    }
}
