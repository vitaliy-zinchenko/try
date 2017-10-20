package zinjvi.algo.tree;

/**
 * @author Vitalii Zinchenko
 */
public class B23Tree<K extends Comparable<K>> {

    private Node root;

    public B23Tree() {
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public class Node {
        private K lessKey;
        private K greaterKey;
        private Node less;
        private Node medium;
        private Node greater;

        public Node(K lessKey) {
            this.lessKey = lessKey;
        }

        public Node(K lessKey, K greaterKey) {
            this.lessKey = lessKey;
            this.greaterKey = greaterKey;
        }

        public Node(K lessKey, K greaterKey, Node less, Node medium, Node greater) {
            this.lessKey = lessKey;
            this.greaterKey = greaterKey;
            this.less = less;
            this.medium = medium;
            this.greater = greater;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (lessKey != null ? !lessKey.equals(node.lessKey) : node.lessKey != null) return false;
            if (greaterKey != null ? !greaterKey.equals(node.greaterKey) : node.greaterKey != null) return false;
            if (less != null ? !less.equals(node.less) : node.less != null) return false;
            if (medium != null ? !medium.equals(node.medium) : node.medium != null) return false;
            return greater != null ? greater.equals(node.greater) : node.greater == null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "lessKey=" + lessKey +
                    ", greaterKey=" + greaterKey +
                    ", less=" + less +
                    ", medium=" + medium +
                    ", greater=" + greater +
                    '}';
        }
    }

    public void insert(K key) {
        root = insert(root, key);
    }

    private Node insert(Node node, K key) {
        if(node == null) return new Node(key);

        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        B23Tree<?> b23Tree = (B23Tree<?>) o;

        return root != null ? root.equals(b23Tree.root) : b23Tree.root == null;
    }

    @Override
    public int hashCode() {
        return root != null ? root.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "B23Tree{" +
                "root=" + root +
                '}';
    }
}
