package algorithm.Stack.mystack;

public interface Stack<T> {
    boolean isEmpty();

    void push(T data);

    T pop();

    T peek();
}
