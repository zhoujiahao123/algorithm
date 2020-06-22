package algorithm.Queue.topkfrequentelements;

import java.util.*;

public class Solution1 {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));
        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }
        // build output list
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
            top_k.add(heap.poll());
        Collections.reverse(top_k);
        int[] res = new int[top_k.size()];
        for (int i = 0; i < top_k.size(); i++) {
            res[i] = top_k.get(i);
        }
        return res;
    }
}
