package algorithm.Stack.mystack;

import java.util.Arrays;
import java.util.Objects;

public class MyStack<T> implements Stack<T> {
    private int size;
    private T[] array;
    private int top = -1;
    private int capacity = 10;

    public MyStack(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public MyStack() {
        array = (T[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void push(T data) {
        if (array.length == size) {
            ensureCapacity(size * 2 + 1);
        }
        array[++top] = data;
        ++size;
    }

    public void ensureCapacity(int capacity) {
        if (capacity < size) {
            return;
        }
        array = Arrays.copyOf(array, capacity);
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        size--;
        return array[top--];
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;
        return array[top];
    }
}
