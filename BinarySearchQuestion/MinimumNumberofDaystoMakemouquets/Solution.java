package algorithm.BinarySearchQuestion.MinimumNumberofDaystoMakemouquets;

public class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) {
            return -1;
        }
        int len = bloomDay.length;
        int left = 1, right = (int) 1e9;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int flow = 0, bouq = 0;
            for (int i = 0; i < len; i++) {
                if (bloomDay[i] > mid) {
                    flow = 0;
                } else if (++flow >= k) {
                    bouq++;
                    flow = 0;
                }
            }
            if (bouq < m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
