package algorithm.TwoPoint.PartitionList;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode result = l1,behind=l2;
        while (head != null) {
            if (head.val >= x) {
                l2.next = new ListNode(head.val);
                l2 = l2.next;
            }else {
                l1.next = new ListNode(head.val);
                l1 = l1.next;
            }
            head = head.next;
        }
        l1.next = behind.next;
        return result.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
