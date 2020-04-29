package algorithm.Queue.FirstUniqueNumber;

import java.util.HashMap;
import java.util.Map;

class FirstUnique {
    class Node {
        int value;
        Node pre;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private Map<Integer, Integer> countMap;

    public void addToHead(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next = node;
        node.next.pre = node;
    }

    public void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public FirstUnique(int[] nums) {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        head.pre = null;
        tail.next = null;
        tail.pre = head;
        map = new HashMap<>();
        countMap = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                if (countMap.get(i) != 2) {
                    deleteNode(map.get(i));
                    countMap.put(i, 2);
                }
            } else {
                Node node = new Node(i);
                map.put(i, node);
                addToHead(node);
                countMap.put(i, 1);
            }
        }
    }

    public int showFirstUnique() {
        return tail.pre == head ? -1 : tail.pre.value;
    }

    public void add(int value) {
        if (map.containsKey(value)) {
            if (countMap.get(value) != 2) {
                deleteNode(map.get(value));
                countMap.put(value, 2);
            }
        } else {
            Node node = new Node(value);
            map.put(value, node);
            addToHead(node);
            countMap.put(value, 1);
        }
    }
}