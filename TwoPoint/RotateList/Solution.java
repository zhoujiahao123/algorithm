package algorithm.TwoPoint.RotateList;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode pre = null, cur = head, result=null, a = head;
        int len = 0, i = 0;
        while (a != null) {
            a = a.next;
            len++;
        }
        if(len == 1){
            return head;
        }
        k = k%len;
        while (cur != null) {
            if (len == k + i) {
                if(i == 0) return head;
                pre.next = null;
                result = cur;
                while (cur.next!=null){
                    cur = cur.next;
                }
                cur.next = head;
                return result;
            }
            if(i == 0){
                pre = head;
            }else {
                pre = pre.next;
            }
            cur = cur.next;
            i++;
        }
        return result;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
