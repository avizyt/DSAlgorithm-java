package leetcodes.llist;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){

    ListNode dummy = new ListNode();
    ListNode curr = dummy;
    int carry = 0;

    while (l1 != null || l2 != null){
        int sum = carry;

        if(l1!= null){
            sum += l1.val;
            l1 = l1.next;
        }
        if (l2 != null){
            sum += l2.val;
            l2 = l2.next;
        }

        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        carry = sum /10;
    }

    if (carry > 0){
        curr.next = new ListNode(carry);
    }

    return  dummy.next;

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
        // Test Case 1: Both lists have the same length
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result1 = AddTwoNumbers.addTwoNumbers(l1, l2); // Expected: 7 -> 0 -> 8
        printLL(result1);
    }
}
