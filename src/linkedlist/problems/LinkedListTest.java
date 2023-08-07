package linkedlist.problems;

import linkedlist.GenericLinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.insertAtBeginning(10);
        list.insertAtBeginning(5);
        list.insertAtEnd(15);
        list.insertAtIndex(3, 20);
        list.display();
    }
}
