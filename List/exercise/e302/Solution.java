package algorithm.List.exercise.e302;

import java.util.ArrayList;

public class Solution {

    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        //反转单链表
        Node temp = node2.next;//记住一定是记录next;
        node2.next = node1;
        node1.next = temp;
        System.out.println(1);
    }
}
