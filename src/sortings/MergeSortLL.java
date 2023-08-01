package sortings;

class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class MergeSortLL {

    private static Node merge(Node list1, Node list2){
        Node mergedList = new Node(-1);
        Node current = mergedList;

        while (list1 != null && list2 != null){
            if (list1.data <= list2.data){
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 != null){
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }

        return mergedList.next;
    }

    // Divide the list into two sublist
    private static Node[] divide(Node head){
        Node[] subLists = new Node[2];
        Node slow = head;
        Node fast = head.next;

        while (fast != null){
            fast = fast.next;
            if (fast != null){
                slow = slow.next;
                fast = fast.next;
            }
        }

        subLists[0] = head;
        subLists[1] = slow.next;
        slow.next = null;

        return subLists;
    }

    // perform natural merge sort
    public static Node naturalMergeSort(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node[] subLists = divide(head);
        Node left = naturalMergeSort(subLists[0]);
        Node right = naturalMergeSort(subLists[1]);

        return merge(left, right);
    }

    // Utility function to print the linked list
    public static void printList(Node head){
        Node current = head;
        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Test the natural merge sort
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(5);
        head.next.next = new Node(15);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(20);
        head.next.next.next.next.next = new Node(3);

        System.out.println("Original Linked List:");
        printList(head);

        head = naturalMergeSort(head);

        System.out.println("Sorted Linked List:");
        printList(head);
    }

}
