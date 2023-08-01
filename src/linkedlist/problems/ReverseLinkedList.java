package linkedlist.problems;

/**
 * Given a singly linked list, the task is to reverse the order of its nodes.
 * Explanation:
 * Initialize three pointers: prev, current, and next. Set prev to null, current to the head of the linked list, and next to null.
 * Traverse the linked list from the head while the current pointer is not null.
 * In each iteration:
 * Store the next node of the current node to preserve the link to the next node.
 * Reverse the next pointer of the current node to point to the prev node.
 * Move prev to the current node.
 * Move current to the next node (next).
 * After the traversal, the prev pointer will be pointing to the new head of the reversed linked list.
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList reverser = new ReverseLinkedList();

        // testing the code
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original Linked List:");
        reverser.printList(head);

        ListNode reversedList = reverser.reverse(head);

        System.out.println("Reversed Linked List:");
        reverser.printList(reversedList);
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        // 1 -> 2 -> 3 -> 4 -> 5 -> null
        while (curr != null){
            next = curr.next; // Store the next node to preserve the link
            curr.next = prev; // Reverse the next pointer of current node
            prev = curr;      // Move prev to the current node
            curr = next;      // Move current to the next node
        }

        // prev will be pointing to the new head of the reversed linked list
        return prev;
    }

    // print the list
    public void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
