package algorithms_hw_1;

public class search_tree<T extends Comparable<T>> {

    private Node<T> root;

    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;
        boolean isRed;

        Node(T value, boolean isRed) {
            this.value = value;
            this.isRed = isRed;
        }
    }

    public void insert(T value) {
        root = insert(root, value);
        root.isRed = false; // корень всегда должен быть черным
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            return new Node<T>(value, true); // новые ноды всегда красные
        }

        int cmp = value.compareTo(node.value);
        if (cmp < 0) {
            node.left = insert(node.left, value);
        } else if (cmp > 0) {
            node.right = insert(node.right, value);
        } else {
            throw new IllegalArgumentException("Value already exists in the tree.");
        }

        // балансировка
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    private boolean isRed(Node<T> node) {
        if (node == null) {
            return false;
        }
        return node.isRed;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> x = node.right;
        node.right = x.left;
        x.left = node;
        x.isRed = node.isRed;
        node.isRed = true;
        return x;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> x = node.left;
        node.left = x.right;
        x.right = node;
        x.isRed = node.isRed;
        node.isRed = true;
        return x;
    }

    private void flipColors(Node<T> node) {
        node.isRed = true;
        node.left.isRed = false;
        node.right.isRed = false;
    }

}
