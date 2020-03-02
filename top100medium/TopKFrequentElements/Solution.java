package algorithm.top100medium.TopKFrequentElements;

import java.util.*;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i : nums) {
            maps.put(i, maps.getOrDefault(i, 0)+1);
        }
        List<Integer>[] list = new List[nums.length + 1];
        for (int n : maps.keySet()) {
            int freq = maps.get(n);
            if (list[freq] == null) list[freq] = new LinkedList<>();
            list[freq].add(n);
        }
        List<Integer> result = new LinkedList<>();
        for (int i = list.length - 1; i > 0 && k > 0; --i) {
            if (list[i] != null) {
                result.addAll(list[i]);
                k -= list[i].size();
            }
        }
        return result;
    }

}
