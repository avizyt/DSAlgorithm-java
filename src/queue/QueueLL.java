package queue;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueLL<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int n;

    private static class Node<Item>{
        private Item data;
        private Node<Item> next;
    }
    public QueueLL() {
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }
    public int size() {
        return n;
    }
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.data;
    }
    public void enqueue(Item data){
        Node<Item> newNode = last;
        last = new Node<>();
        last.data = data;
        last.next = null;
        if (isEmpty()) first = last;
        else newNode.next = last;
        n++;
    }
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue overflow");
        Item data = first.data;
        first = first.next;
        n--;
        if (isEmpty()) last = null;
        return data;
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this){
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> curr;
        public LinkedIterator(Node<Item> first) {
            curr = first;
        }
        public boolean hasNext() {
            return curr != null;
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item data = curr.data;
            curr = curr.next;
            return data;
        }
    }
    public static void main(String[] args){
        QueueLL<String> queue = new QueueLL<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                queue.enqueue(item);
            else if (!queue.isEmpty())
                StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }
}
