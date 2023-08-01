package linkedlist.problems;

/**
 * Given two singly linked lists, the task is to determine if they intersect (have a common node).
 * If they intersect, return the intersection node.
 */
public class IntersectionOfLinkedList {

    public static void main(String[] args) {
        IntersectionOfLinkedList intersectionFinder = new IntersectionOfLinkedList();

        // Example usage to test the algorithm
        // Common intersection node: 8
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next; // Intersection

        System.out.println("Linked List A:");
        intersectionFinder.printList(headA);

        System.out.println("Linked List B:");
        intersectionFinder.printList(headB);

        ListNode intersectionNode = intersectionFinder.getIntersectionNode(headA, headB);
        if (intersectionNode != null) {
            System.out.println("Intersection Node: " + intersectionNode.val); // Output: Intersection Node: 8
        } else {
            System.out.println("No Intersection Node");
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // FInd the length and last nodes of the two linked list
        int lenA = 0, lenB = 0;
        ListNode tailA = null , tailB = null;

        ListNode currA = headA;
        ListNode currB = headB;

        while (currA != null) {
            lenA++;
            tailA = currA;
            currA = currA.next;
        }

        while (currB != null) {
            lenB++;
            tailB = currB;
            currB = currB.next;
        }

        // If the last nodes are different, the list do not intersect
        if (tailA != tailB) {
            return null;
        }

        // Reset pointer to the heads of the list
        currA = headA;
        currB = headB;

        // Move the longer pointer forward so that both lists have the same number of nodes
        while (lenA > lenB) {
            currA = currA.next;
            lenA--;
        }

        while (lenB > lenA){
            currB = currB.next;
            lenB--;
        }

        // Traverse both lists simultaneously to find intersection nodes
        while (currA != currB){
            currA = currA.next;
            currB = currB.next;
        }

        // Return the intersection node (or null if no intersection)
        return currA;
    }

    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
