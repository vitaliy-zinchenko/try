package zinjvi.algo.tree;

/**
 * @author Vitalii Zinchenko
 */
public class AvlTree<K extends Comparable<K>> {

    private Node root;

    protected class Node {
        private int height;
        private K key;
        private Node left;
        private Node right;

        public Node(K key) {
            this.key = key;
        }

        public Node(K key, int height, Node left, Node right) {
            this.key = key;
            this.height = height;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (height != node.height) return false;
            if (key != null ? !key.equals(node.key) : node.key != null) return false;
            if (left != null ? !left.equals(node.left) : node.left != null) return false;
            return right != null ? right.equals(node.right) : node.right == null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", height=" + height +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void insert(K key) {
        root = insert(root, key);
    }

    private Node insert(Node node, K key) {
        if (node == null) return new Node(key);

        int compare = key.compareTo(node.key);
        if (compare < 0) node.left = insert(node.left, key);
        if (compare > 0) node.right = insert(node.right, key);

        updateHeight(node);

        return balance(node);
    }

    private void updateHeight(Node node) {
        int left = node.left == null ? -1 : node.left.height;
        int right = node.right == null ? -1 : node.right.height;
        node.height = Math.max(left, right) + 1;
    }

    private Node balance(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            if (height(node.left.left) > height(node.left.right)) {
                return rightRotate(node);
            } else {
                return leftRightRotate(node);
            }
        } else if (height(node.right) - height(node.left) > 1) {
            if (height(node.right.right) > height(node.right.left)) {
                return leftRotate(node);
            } else {
                return rightLeftRotate(node);
            }
        }
        return node;
    }

    private Node rightRotate(Node node) {
        Node root = node.left;
        node.left = root.right;
        root.right = node;
        updateHeight(node);
        updateHeight(root);
        return root;
    }

    private Node leftRightRotate(Node node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    private Node leftRotate(Node node) {
        Node root = node.right;
        node.right = root.left;
        root.left = node;
        updateHeight(node);
        updateHeight(root);
        return root;
    }

    private Node rightLeftRotate(Node node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    private int height(Node node) {
        return node == null ? -1 : node.height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AvlTree<?> avlTree = (AvlTree<?>) o;

        return root != null ? root.equals(avlTree.root) : avlTree.root == null;
    }

    @Override
    public String toString() {
        return "AvlTree{" +
                "root=" + root +
                '}';
    }
}
