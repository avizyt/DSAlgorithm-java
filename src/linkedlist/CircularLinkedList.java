package linkedlist;


public class CircularLinkedList {
    class Node{
        int data;
        Node next;

        private Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public Node head;
    public int size;

    public CircularLinkedList(){
        head = null;
        size = 0;
    }
    // add node to the end of the circular linked list
    public void add(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            head.next = head;
        } else {
            Node current = head;
            while (current.next != head){
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
        size++;
    }

    public void removeHead(){
        if (head != null){
            Node current = head;
            while (current.next != head){
                current = current.next;
            }
            current.next = head.next;
            head = head.next;
            size--;
        }
    }

    public void display(){
        if (head == null){
            System.out.println("Circular linked list is empty:");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public int getSize() {
        return  size;
    }
}
