package leetcodes.basics;


public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode middleNode = findMiddle(head);
        System.out.println(middleNode.val);
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    private static ListNode findMiddle(ListNode head){
        if (head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            // The slow pointer moves 1 step at a time.
            // But fast pointer moves 2 step at a time.
            // So, when the fast pointer reach at the end of the list,
            // The slow pointer only reached the middle of the list.
            // so, the slow pointer will be the answer.

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


}
