package dataabstraction;

import edu.princeton.cs.algs4.Bag;

import java.util.Iterator;

public class BagLL<Item> implements Iterable<Item> {
    private Node first;
    private class Node {
        Item item;
        Node next;
    }

    public void add(Item item){
        Node curr = first;
        first = new Node();
        first.item = item;
        first.next = curr;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node curr = first;
        public boolean hasNext() {
            return curr != null;
        }
        public void remove() {
            
        }
        public Item next(){
            Item item = curr.item;
            curr = curr.next;
            return item;
        }
    }

    public static void main(String[] args) {
        BagLL<Integer> bag = new BagLL<>();
        Bag<Integer> b1 = new Bag<>();
        for (int i = 0; i < 10; i++) {
            bag.add(i);
            b1.add(i);
        }
        System.out.println(bag);
        
    }
}
