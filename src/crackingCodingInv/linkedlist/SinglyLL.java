package crackingCodingInv.linkedlist;


class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class SinglyLL {

    private Node head;
    private int size;

    public SinglyLL() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty(){ return head == null;}
    public int getSize() { return size;}

    public void insertAtBeginning(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if (isEmpty()){
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }

    public void display() {
        if (isEmpty()){
            System.out.println("linked list is empty");
        }
        Node curr = head;
        while (curr != null){
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLL ll = new SinglyLL();
        ll.insertAtBeginning(10);
        ll.insertAtBeginning(20);
        ll.insertAtBeginning(30);

        System.out.println("Linked list elements");
        ll.display();

    }
}
