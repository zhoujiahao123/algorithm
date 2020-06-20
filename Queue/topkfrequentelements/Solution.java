package algorithm.Queue.topkfrequentelements;

import java.util.*;

public class Solution extends PriorityQueue<Solution.Status> {
    static class Status implements Comparable<Status> {
        int id;
        int primary;

        public Status(int id, int primary) {
            this.id = id;
            this.primary = primary;
        }

        @Override
        public int compareTo(Status o) {
            if (primary > o.primary) {
                return -1;
            }
            if (primary == o.primary) {
                return 0;
            }
            return 1;
        }

    }

    public void add(int id, int primary) {
        super.add(new Status(id, primary));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.merge(i, 1, Integer::sum);
        }
        Solution solution = new Solution();
        for (Integer key : map.keySet()) {
            solution.add(key, map.get(key));
        }
        List<Integer> list = new ArrayList<>();
        while (solution.peek() != null && k > 0) {
            Status status = solution.remove();
            list.add(status.id);
            k--;
        }
        int result[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
