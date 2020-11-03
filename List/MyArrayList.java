package algorithm.List;

import java.util.*;

public class MyArrayList<T> implements Iterable, List {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int modCount;

    public MyArrayList() {
        clear();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) > -1;
    }

    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    @Override
    public Object[] toArray() {
        return data;
    }

    @Override
    public boolean add(Object o) {
        add(size(), o);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1) return false;
        remove(index);
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        Object[] objects = c.toArray();
        System.arraycopy(objects, 0, data, size, objects.length);
        size += objects.length;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < data.length; i++) data[i] = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        checkArrange(index);
        return data[index];
    }

    @Override
    public Object set(int index, Object element) {
        checkArrange(index);
        Object oldVal = data[index];
        data[index] = element;
        return oldVal;
    }

    @Override
    public void add(int index, Object element) {
        modCount++;
        if (data.length == size()) {
            data = Arrays.copyOf(data, size() * 2 + 1);
        }
        System.arraycopy(data, index, data, index + 1, size() - index);
        data[index] = element;
        size++;
    }

    @Override
    public Object remove(int index) {
        modCount++;
        checkArrange(index);
        Object element = data[index];
        int numMove = size() - index - 1;
        System.arraycopy(data, index + 1, data, index, numMove);
        data[size--] = null;
        return element;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < data.length; i++) if (o.equals(data[i])) return i;
        return -1;
    }

    private class ArrayListIterator implements Iterator {
        int expectedModCount = modCount;
        int cursor = 0;
        int lastRet = -1;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Object next() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (cursor >= size) {
                return new NoSuchElementException();
            }
            return data[lastRet = ++cursor];
        }

        @Override
        public void remove() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (lastRet == -1) {
                throw new IllegalStateException();
            }
            MyArrayList.this.remove(lastRet);
            lastRet = -1;
            expectedModCount = modCount;
        }
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
        return data;
    }

    private void checkArrange(int index) {
        if ((index < 0 || index > data.length - 1)) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
