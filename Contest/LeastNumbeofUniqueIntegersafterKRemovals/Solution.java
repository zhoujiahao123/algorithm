package algorithm.Contest.LeastNumbeofUniqueIntegersafterKRemovals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        new Solution().findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1);
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            map.merge(arr[i], 1, Integer::sum);
        }
        int len = 0;
        len = map.size();
        int[] res = new int[len];
        int kRes = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res[kRes++] = entry.getValue();
        }
        Arrays.sort(res);
        for (int i = 0; i < res.length; i++) {
            k -= res[i];
            if (k == 0) {
                return res.length - i - 1;
            } else if (k < 0) {
                return res.length - i;
            }
        }
        return 0;
    }
}