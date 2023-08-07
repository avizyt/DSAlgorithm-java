package linkedlist;

public class GenericDoublyLinkedList<T> {
    class Node<T>{
        private T data;
        private Node<T> prev;
        private Node<T> next;

        private Node(T data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
        private T getData(){
            return data;
        }
        private void setData(T data){
            this.data = data;
        }
        private Node<T> getPrev() {
            return prev;
        }

        private void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        private Node<T> getNext() {
            return next;
        }

        private void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public GenericDoublyLinkedList() {
        this.head = head;
        this.tail = tail;
        this.size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T data){
        Node<T> newNode = new Node<>(data);
        if (isEmpty()){
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    public void addLast(T data){
        Node<T> newNode = new Node<>(data);
        if (isEmpty()){
            head = newNode;
        }else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    public T removeFirst(){
        if (isEmpty()){
            throw new IllegalStateException("Linked list is empty");
        }
        T data = head.getData();
        head = head.getNext();
        if (head != null){
            head.setPrev(null);
        } else {
            tail = null;
        }
        size--;
        return data;
    }

    public T removeLast() {
        if (isEmpty()){
            throw new IllegalStateException("Linked list is empty");
        }
        T data = tail.getData();
        tail = tail.getPrev();
        if (tail != null){
            tail.setNext(null);
        } else {
            head = null;
        }
        size--;
        return data;
    }
    public void displayForward() {
        Node<T> current = head;
        System.out.print("Forward: ");
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public void displayReverse() {
        Node<T> current = tail;
        System.out.print("Reverse: ");
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getPrev();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GenericDoublyLinkedList<Integer> dll = new GenericDoublyLinkedList<>();
        dll.addFirst(1);
        dll.addLast(2);
        dll.addLast(3);

        dll.displayForward();
        dll.displayReverse();
        System.out.println("List size: "+ dll.size());
        dll.removeFirst();
        dll.displayForward();
        dll.displayReverse();
        System.out.println("Now after remove: "+ dll.size());
    }
}
