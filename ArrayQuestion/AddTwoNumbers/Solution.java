package algorithm.ArrayQuestion.AddTwoNumbers;

import java.util.List;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = l1, q = l2, curr = result;
        int carry = 0;
        while (p != null || q != null) {
            int x = l1 == null ? 0 : p.val;
            int y = l2 == null ? 0 : q.val;
            int value = x + y + carry;
            carry = value / 10;
            curr.next = new ListNode(value%10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return result.next;
    }

//    private void solve(ListNode l1, ListNode l2, ListNode result) {
//        if (l1 == null && l2 == null) {
//            //要判断是否有进位，因为存在[5],[5]情况
//            if (!isJinWei) {
//                return;
//            } else {
//                int nowValue = 1;
//                ListNode node = new ListNode(nowValue);
//                result.next = node;
//                return;
//            }
//        }
//        int extra = isJinWei ? 1 : 0;
//        int v1 = l1 ==null?0:l1.val;
//        int v2 = l2 ==null?0:l2.val;
//        int nowValue = v1 + v2 + extra;
//        if (nowValue >= 10) {
//            isJinWei = true;
//            nowValue -= 10;
//        } else {
//            isJinWei = false;
//        }
//        ListNode node = new ListNode(nowValue);
//        result.next = node;
//        solve(l1.next, l2.next, node);
//    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
