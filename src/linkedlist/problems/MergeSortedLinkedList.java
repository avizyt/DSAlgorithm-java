package linkedlist.problems;

public class MergeSortedLinkedList {

    public static void main(String[] args) {
        MergeSortedLinkedList merger = new MergeSortedLinkedList();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode( 4);
        l2.next.next = new ListNode(6);

        System.out.println("Sorted Linked List 1:");
        merger.printList(l1);

        System.out.println("Sorted Linked List 2:");
        merger.printList(l2);

        ListNode mergedList = merger.merge(l1, l2);

        System.out.println("Merged Sorted Linked List:");
        merger.printList(mergedList);
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // Add remaining non-empty list
        if (l1 != null) {
            curr.next = l1;
        } else {
            curr.next = l2;
        }

        return dummy.next;
    }

    // print list
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
