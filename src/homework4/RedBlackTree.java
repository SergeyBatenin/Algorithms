package homework4;

public class RedBlackTree {
    public Node root; // public для тестирования

    public boolean add(int value) {
        if (root == null) {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        } else {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        }
    }

    private boolean addNode(Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.leftChild == null) {
                    node.leftChild = new Node();
                    node.leftChild.color = Color.RED;
                    node.leftChild.value = value;
                    return true;
                } else {
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                }
            } else {
                if (node.rightChild == null) {
                    node.rightChild = new Node();
                    node.rightChild.color = Color.RED;
                    node.rightChild.value = value;
                    return true;
                } else {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                }
            }
        }
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.RED
                && (result.leftChild == null || result.leftChild.color == Color.BLACK)) {
                    needRebalance = true;
                    result = rightSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED
                && result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED) {
                    needRebalance = true;
                    result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED
                && result.rightChild != null && result.rightChild.color == Color.RED) {
                    needRebalance = true;
                    colorSwap(result);
            }
        } while (needRebalance);
        return result;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    private Node rightSwap (Node node) {
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return  rightChild;
    }

    private void colorSwap(Node node) {
        node.color = Color.RED;
        node.leftChild.color = Color.BLACK;
        node.rightChild.color = Color.BLACK;
    }

    public class Node { // Класс также открыт только для тестирования значений
        public int value;
        public Color color;
        public Node leftChild;
        public Node rightChild;
    }
    private enum Color {
        RED,
        BLACK
    }
}
