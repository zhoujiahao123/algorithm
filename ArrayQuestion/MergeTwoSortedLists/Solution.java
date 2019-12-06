package algorithm.ArrayQuestion.MergeTwoSortedLists;

import java.util.List;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2, curr = new ListNode(0);
        ListNode result = curr;
        while (p != null && q != null) {
            if (p.val == q.val) {
                ListNode node = new ListNode(p.val);
                curr.next = node;
                curr = curr.next;
                ListNode node1 = new ListNode(q.val);
                curr.next = node1;
                curr = curr.next;
                p = p.next;
                q = q.next;
            } else if (p.val > q.val) {
                ListNode node = new ListNode(q.val);
                curr.next = node;
                curr = curr.next;
                q = q.next;
            } else {
                ListNode node = new ListNode(p.val);
                curr.next = node;
                curr = curr.next;
                p = p.next;
            }
        }
        if (p == null && q == null) {
            return result.next;
        }else if(p == null){
            curr.next = q;
            return result.next;
        }else {
            curr.next = p;
            return result.next;
        }

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
