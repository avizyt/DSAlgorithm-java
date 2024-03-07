package leetcodes.llist;

public class MiddleOfLinkedList {
    public static ListNode findMiddle(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static void printLL(ListNode head){
        ListNode curr = head;
        while (curr != null){
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode ll = new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1)))));
        ListNode result = MiddleOfLinkedList.findMiddle(ll);
        printLL(result);
    }
}
