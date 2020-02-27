package algorithm.TwoPoint.PalindromeLinkedList;

import java.util.List;

public class Solution {
    ListNode ref;

    public boolean isPalindrome(ListNode head) {
        ref = head;
        if (head == null) return false;
        return solve(head);
    }

    public boolean solve(ListNode node) {
        if(node == null) return true;
        boolean val = solve(node.next);
        int refVal = ref.val;
        ref = ref.next;
        return val&&(refVal == node.val);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
