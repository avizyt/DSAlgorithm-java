package linkedlist.problems;

public class CircularClosed {
    public class CircularLinkedList {
        public static boolean isCircular(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;

            while (fast != null && fast.next != null) {
                if (slow == fast) {
                    return true;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return false;
        }
    }

        public static void main(String[] args) {
            ListNode station1 = new ListNode(1);
            ListNode station2 = new ListNode(2);
            ListNode station3 = new ListNode(3);

            station1.next = station2;
            station2.next = station3;
            station3.next = station1; // The circular link

            System.out.println("Is the network closed? " + CircularLinkedList.isCircular(station1)); // Output: true
        }

    }