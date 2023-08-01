package linkedlist.problems;

public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move the fast pointer n+1 steps forward
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until the fast pointer reaches the last node
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Adjust the slow pointer to skip the n-th node
        slow.next = slow.next.next;

        return dummy.next;
    }

    // Printer function
    public void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEnd remover = new RemoveNthNodeFromEnd();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original Linked List");
        remover.printList(head);

        int n =2;
        ListNode updatedHead = remover.removeNthFromEnd(head, n);

        System.out.println("Updated Linked List after removing the " + n + "-th node from the end:");
        remover.printList(updatedHead);

    }
}
