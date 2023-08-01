package linkedlist.problems;
/***
 * 2. Problem: Detect Cycle in a Linked List
 * Description: Given a singly linked list, determine if it contains a cycle
 * (i.e., a node points back to a previously visited node).
 * Real-World Use Case: In GPS navigation apps, a linked list-like data structure stores
 * the sequence of roads and intersections.Detecting cycles in this context helps identify
 * if there are loops or recurring paths in the road network, which can help avoid navigating
 * in circles and optimize route calculations.
 */


public class LinkedListCycle {
    public boolean hasCycle(ListNode head){
        if (head == null || head.next == null){
            // An empty list or a list with only one node cannot have a cycle
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next; // move slow pointer 1 step
            fast = fast.next.next; //move fast pointer 2 step

            if (slow == fast){
                // The fast pointer has caught up to the slow pointer, indicating a cycle
                return true;
            }
        }
        // The fast pointer reached the end of the list, indicating no cycle
        return false;
    }

    public static void main(String[] args) {

        // Test Case 1: Empty Linked List
        LinkedListCycle cycleDetector = new LinkedListCycle();
        boolean hasCycle = cycleDetector.hasCycle(null);
        System.out.println("Test Case 1: Empty Linked List - Has Cycle: " + hasCycle); // Output: Test Case 1: Empty Linked List - Has Cycle: false

        // Test Case 2: Linked List with No Cycle
        ListNode headNoCycle = new ListNode(1);
        headNoCycle.next = new ListNode(2);
        headNoCycle.next.next = new ListNode(3);
        headNoCycle.next.next.next = new ListNode(4);

        hasCycle = cycleDetector.hasCycle(headNoCycle);
        System.out.println("Test Case 2: Linked List with No Cycle - Has Cycle: " + hasCycle); // Output: Test Case 2: Linked List with No Cycle - Has Cycle: false

        // Test Case 3: Linked List with Cycle
        ListNode headWithCycle = new ListNode(1);
        headWithCycle.next = new ListNode(2);
        headWithCycle.next.next = new ListNode(3);
        headWithCycle.next.next.next = new ListNode(4);
        headWithCycle.next.next.next.next = headWithCycle.next; // Creating a cycle: 4 -> 2

        hasCycle = cycleDetector.hasCycle(headWithCycle);
        System.out.println("Test Case 3: Linked List with Cycle - Has Cycle: " + hasCycle); // Output: Test Case 3: Linked List with Cycle - Has Cycle: true

        // Test Case 4: Linked List with Self Loop (Cycle of size 1)
        ListNode headSelfLoop = new ListNode(1);
        headSelfLoop.next = headSelfLoop; // Self loop: 1 -> 1

        hasCycle = cycleDetector.hasCycle(headSelfLoop);
        System.out.println("Test Case 4: Linked List with Self Loop - Has Cycle: " + hasCycle); // Output: Test Case 4: Linked List with Self Loop - Has Cycle: true
    }
}
