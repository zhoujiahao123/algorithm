package algorithm.TwoPoint.LinkedListCycleII;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        boolean isFirst = true;
        while (fast != null && slow != null) {
            if (!isFirst && fast == slow) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            } else {
                slow = slow.next;
                fast = fast.next;
                if (fast == null) {
                    return null;
                }
                fast = fast.next;
            }
            isFirst = false;
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
