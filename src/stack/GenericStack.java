package stack;

import java.util.LinkedList;

public class GenericStack<T> {

    private final LinkedList<T> stack;

    public GenericStack() {
        stack = new LinkedList<>();
    }

    public void push(T elem) {
        stack.addFirst(elem);
    }

    public T pop() {
        if (stack.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return stack.removeFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        } return stack.getFirst();
    }

    public void clear() {
        stack.clear();
    }
    @Override
    public String toString() {
        return  stack.toString();
    }


    public static void main(String[] args) {
        GenericStack<Integer> stk = new GenericStack<>();
        for (int i = 1; i <= 20; i++) {
            stk.push(i);
        }
        System.out.println(stk);
        while (stk.size() != 0){
            if (stk.peek() % 2 == 0){
                int even = stk.pop();
                System.out.println("EVEN: " + even);
            }else {
                System.out.println("Not Even");
            }
        }
    }
}
