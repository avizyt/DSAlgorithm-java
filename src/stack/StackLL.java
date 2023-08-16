package stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackLL<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int n;

    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }
    public StackLL() {
        first = null;
        n = 0;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public int size() {
        return n;
    }

    public void push(Item data){
        Node<Item> newNode = first;
        first = new Node<>();
        first.item = data;
        first.next = newNode;
        n++;
    }
    public Item pop()  {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;
        first = first.next;
        n--;
        return item;

    }
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack overflow");
        return first.item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this){
            s.append(item);
            s.append(" ");
        }
        return s.toString();
    }

    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> curr;
        public LinkedIterator(Node<Item> first){
            curr = first;
        }
        public boolean hasNext(){
            return curr != null;
        }
        public Item next(){
            if (!hasNext()) try {
                throw new NoSuchFieldException();
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
            Item item = curr.item;
            curr = curr.next;
            return item;
        }
    }

//    public static void main(String[] args) {
//        StackLL<String> stack = new StackLL<>();
//        while (!StdIn.isEmpty()) {
//            String item = StdIn.readString();
//            if (!item.equals("-"))
//                stack.push(item);
//            else if (!stack.isEmpty())
//                StdOut.print(stack.pop() + " ");
//        }
//        StdOut.println("(" + stack.size() + " left on stack)");
//    }

//    public static void main(String[] args) {
//        StackLL<Integer> st = new StackLL<>();
//
//        for (int i = 1; i <= 5 ; i++) {
//            int num = 10 * i;
//            st.push(num);
//        }
//        StdOut.println("The fist element of the List: " + st.peek());
//        while (st.size() != 0) {
//            StdOut.println(st.pop());
//        }
//        StdOut.println("(" + st.size() + " left on stack");
//    }

    public static void main(String[] args) {
        StackLL<String> plateStack = new StackLL<>();
        String[] plates = {"plate1", "plate2","plate3","plate4","plate5"};
        for (String plate: plates){
            plateStack.push(plate);
        }
        StdOut.println("The number of plate: " + plateStack.size());
        StdOut.println("The top plate in the stack: " + plateStack.peek());

        while (plateStack.size() != 0){
            StdOut.println(plateStack.pop());
        }
        StdOut.println("The number of plate now: "+ plateStack.size());
    }

}
