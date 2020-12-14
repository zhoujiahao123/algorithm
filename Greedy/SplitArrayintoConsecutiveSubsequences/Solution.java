package algorithm.Greedy.SplitArrayintoConsecutiveSubsequences;

import java.util.*;

public class Solution {

    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, new PriorityQueue<Integer>());
            }
            if (map.containsKey(i - 1)) {
                int preLength = map.get(i - 1).poll();
                if (map.get(i - 1).isEmpty()) {
                    map.remove(i - 1);
                }
                map.get(i).offer(preLength + 1);
            } else {
                map.get(i).offer(1);
            }
        }
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> set = map.entrySet();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : set) {
            PriorityQueue<Integer> queue = entry.getValue();
            if (queue.peek() < 3) {
                return false;
            }
        }
        return true;
    }
}
