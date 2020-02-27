package algorithm.TwoPoint.IntersectionofTwoLinkedLists;

import java.util.List;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode testA = headA;
        int aLen = 0;
        while (testA != null) {
            aLen++;
            testA = testA.next;
        }
        ListNode testB = headB;
        int bLen = 0;
        while (testB != null) {
            bLen++;
            testB = testB.next;
        }
        System.out.println(aLen + ":" + bLen);
        if (aLen > bLen) {
            return solve(aLen - bLen, headA, headB);
        } else {
            return solve(bLen - aLen, headB, headA);
        }
    }

    public ListNode solve(int gap, ListNode a, ListNode b) {
        while (gap != 0) {
            a = a.next;
            gap--;
        }
        while (a != null && b != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
