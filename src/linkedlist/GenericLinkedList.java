package linkedlist;

class Node<T> {
    T item;
    Node<T> next;

    public Node(T item) {
        this.item = item;
        this.next = null;
    }
}
public class GenericLinkedList<T> {
    private Node<T> head;
    private int size;

    // Constructor to initialize an empty linked list
    public GenericLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Method to check if the linked list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // method to get the size of the linked list
    public int getSize() {
        return size;
    }

    // Method to insert an element at the beginning of the linked list
    public void insertAtBeginning(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void insertAtEnd(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()){
            head = newNode;
        } else {
            Node<T> curr = head;
            while (curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }

    // Method to insert an element at a specific index in the linked list
    public void insertAtIndex(int index, T item) {
        if (index <0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            insertAtBeginning(item);
        } else if (index == size) {
            insertAtEnd(item);
        } else {
            Node<T> newNode = new Node<>(item);
            Node<T> prev = null;
            Node<T> curr = head;
            for (int i = 0; i < index; i++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = newNode;
            newNode.next = curr;
            size++;
        }
    }

    // Method to remove an element from the beginning of the linked list
    public T removeFromBeginning() {
        if (isEmpty()) {
            throw new RuntimeException("Linked list is Empty");
        }
        T item = head.item;
        head = head.next;
        size--;
        return item;
    }

    // Method to remove an element from the end of the linked list
    public T removeFromEnd() {
        if (isEmpty()){
            throw new RuntimeException("Linked list is empty");
        }
        if (size == 1) {
            T item = head.item;
            head = null;
            size--;
            return item;
        }
        Node<T> curr = head;
        Node<T> prev = null;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }

        T item = curr.item;
        assert prev != null;
        prev.next = null;
        size--;
        return item;
    }
    // Method to remove an element from a specific index in the linked list
    public T removeFromIndex(int index) {
        if (isEmpty() || index <0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            return removeFromBeginning();
        } else if (index == size -1) {
            return removeFromEnd();
        } else {
            Node<T> prev = null;
            Node<T> curr = head;
            for (int i = 0; i < index; i++) {
                prev = curr;
                curr = curr.next;
            }
            T item = curr.item;
            prev.next = curr.next;
            size--;
            return item;
        }
    }
    // Method to get the element at a specific index in the linked list
    public T get(int index) {
        if (isEmpty() || index< 0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.item;
    }

    // Method to display the elements of the linked list
    public void display() {
        if (isEmpty()){
            System.out.println("linked list is empty");
        }
        Node<T> curr = head;
        while (curr != null){
            System.out.print(curr.item + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        GenericLinkedList<Integer> linkedList = new GenericLinkedList<>();
        linkedList.insertAtEnd(10);
        linkedList.insertAtEnd(20);
        linkedList.insertAtEnd(30);
        linkedList.insertAtBeginning(5);
        linkedList.insertAtIndex(2, 15);

        System.out.println("Linked list elements:");
        linkedList.display();

        int element = linkedList.removeFromBeginning();
        System.out.println("Removed element from the beginning: " + element);

        element = linkedList.removeFromEnd();
        System.out.println("Removed element from the end: " + element);

        System.out.println("Element at index 1: " + linkedList.get(1));

        System.out.println("Linked list elements after removals:");
        linkedList.display();
    }
}
