package homework3;

public class MyList<T> {

    private int size = 0;
    private Node<T> head;
    private Node<T> tail;

    public MyList() {
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void add(T value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Выход за пределы массива");
        }

        if (index == size) {
            add(value);
        } else {
            Node<T> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            Node<T> newNode = new Node<>(value);
            newNode.prev = node.prev;
            newNode.next = node;
            newNode.prev.next = newNode;
            node.prev = newNode;
            size++;
        }
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Выход за пределы массива");
        }

        Node<T> node = null;
        if (index < (size >> 1)) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node.value;
    }

    public void remove() {
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Выход за пределы массива");
        }

        Node<T> node = null;
        if (index < (size >> 1)) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        Node<T> prev = node.prev;
        Node<T> next = node.next;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.value = null;
        size--;
    }

    public void removeFirst() {
        head = head.next;
        head.prev = null;
        size--;
    }

    public void reverse() {
        if (size < 2) return;

        Node<T> node = head;
        revert(node);
        tail = node;
        tail.next = null;
    }
    private void revert(Node<T> node) {

        if (node.next != null) {
            revert(node.next);
        } else {
            head = node;
            head.prev = null;
            return;
        }

        Node<T> temp = node.next;
        node.prev = temp;
        temp.next = node;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (head != null) {
            Node<T> node = head;
            for (int i = 0; i < size - 1; i++) {
                sb.append(node.value);
                sb.append(", ");
                node = node.next;
            }
            sb.append(node.value);
        }
        sb.append("]");
        return sb.toString();
    }

    private class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value) {
            this.value = value;
        }
    }
}
