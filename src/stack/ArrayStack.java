package stack;

import java.util.Arrays;

public class ArrayStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int size;

    public ArrayStack() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Push an element
    public void push(T elem) {
        ensureCapacity();
        data[size++] = elem;
    }

    // Pop and return the top element
    public T pop() {
        if (isEmpty()){
            throw new IllegalStateException("Stack is Empty");
        }
        T elem = getElement(size -1);
        data[size - 1] = null;
        size--;
        shrinkIfNecessary();
        return elem;
    }

    // Peek at the top element without remove
    public T peek() {
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return  getElement(size -1 );
    }

    private T getElement(int idx) {
        return (T) data[idx];
    }

    private void shrinkIfNecessary() {
        int currCap = data.length;
        int newCap = currCap / 2;
        if (size <= newCap && newCap >= DEFAULT_CAPACITY){
            data = Arrays.copyOf(data, newCap);
        }
    }

    // Check empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Size
    public int size() {
        return size;
    }
    // Ensure Capacity
    private void ensureCapacity() {
        if (size == data.length) {
            int newCap = data.length * 2;
            data = Arrays.copyOf(data, newCap);
        }
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stk = new ArrayStack<>();
        for (int i = 0; i < 20; i++) {
            stk.push(i);
        }
        System.out.println("Size of the Stack: " + stk.size());
        while (!stk.isEmpty()){
            System.out.println(stk.pop());
        }
    }
}
