package algorithm.TwoPoint.RemoveNthNodeFromEndofList;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head, a = head, cur = pre;
        int i = 0, len = 1;
        while ((a = a.next) != null) {
            len++;
        }
        while (head != null) {
            if (i == 0) {
                if (len == n) {
                    return head.next;
                }
            } else {
                if (i == len - n) {
                    pre.next = head.next;
                }
                pre = pre.next;
            }
            head = head.next;
            i++;
        }
        return cur;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
