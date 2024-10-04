package core.basesyntax;

import java.util.List;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyLinkedListInterface<T> {
    private int size = 0;
    Node node ;
    Node head = null;
    Node tail = null;

    @Override
    public void add(T value) {
        Node node = new Node<>(null, value, null);
        if (head == null) {
            head = tail = node;
            size++;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
            size++;
        }

    }

    @Override
    public void add(T value, int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node node = new Node( value, index);
        if(index == size) {
            add(value);
        }
        if (index == 0) {
            head.prev = node;
            node.next = head;
            head = node;
        } else {

        }


    }

    @Override
    public void addAll(List<T> list) {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(T value, int index) {
        return null;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean remove(T object) throws NoSuchElementException {
        throw new NoSuchElementException("Element " + object + " was not found");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public void check(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }
}

class Node<T> {
    private T item;
    Node prev;
    Node next;
    int index;

    public Node(Node prev, T item, Node next) {
        this.prev = prev;
        this.item = item;
        this.next = next;
    }

    public Node(T item, int index) {
        this.item = item;
        this.index = index;
    }
}
