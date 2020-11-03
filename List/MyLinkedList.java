package algorithm.List;

import java.util.*;

public class MyLinkedList<T> implements List {
    private int size;
    private int modCount;
    private Node head;
    private Node tail;


    private class Node<T> {
        Node pre;
        Node next;
        T data;

        public Node(Node pre, Node next, T x) {
            data = x;
            this.pre = pre;
            this.next = next;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[size];
        int cursor = 0;
        for (Node temp = head; temp != null; temp = temp.next) {
            objects[cursor++] = temp.data;
        }
        return objects;
    }

    @Override
    public boolean add(Object o) {
        linkLast((T) o);
        return true;
    }

    void linkLast(T x) {
        Node<T> t = tail;
        Node<T> node = new Node<>(t, null, x);
        tail = node;
        if (t == null) {
            head = node;
        } else {
            t.next = node;
        }
        size++;
        modCount++;
    }

    void linkFirst(T x) {
        Node<T> f = head;
        Node<T> node = new Node<>(null, f, x);
        head = node;
        if (f == null) {
            tail = node;
        } else {
            f.pre = head;
        }
        size++;
        modCount++;
    }

    void linkBefore(T x, Node<T> suc) {
        Node<T> pre = suc.pre;

        Node<T> node = new Node<>(pre, suc, x);
        suc.pre = node;
        if (pre == null) {
            head = node;
        } else {
            pre.next = node;
        }
        size++;
        modCount++;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
