package stack;

import java.util.Iterator;

public class BagLL<T> implements Iterable<T> {
    private Node<T> first;
    private int n;

    private static class Node<T>{
        private T data;
        private Node<T> next;
    }

    public BagLL() {
        first = null;
        n = 0;
    }

    public boolean isEmpty(){
        return first == null;
    }
    public int size() {
        return n;
    }

    public void add(T data){
        Node<T> newNode = first;
        first = new Node<>();
        first.data = data;
        first.next = newNode;
        n++;
    }
    public Iterator<T> iterator() {
        return new BagIterator(first);
    }
    private class BagIterator implements Iterator<T> {
        private Node<T> curr;
        public BagIterator(Node<T> first){
            curr = first;
        }
        public boolean hasNext() { return curr != null;}

        public T next(){
            if (!hasNext()) try {
                throw new NoSuchFieldException();
            } catch (NoSuchFieldException e){
                throw new RuntimeException(e);
            }
            T data = curr.data;
            curr = curr.next;
            return data;
        }
    }
    public static void main(String[] args) {
        BagLL<Integer> bag = new BagLL<>();
        for (int i = 10; i <= 15 ; i++) {
            bag.add(i);
        }
        for (int x: bag){
            System.out.println(x);
        }
    }

}
