package algorithm.Contest.FourDivisors;

public class Solution {
    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for (int i : nums) {
            boolean even = (i & 1) == 0;
            double s = Math.sqrt(i);
            int count = 2;
            int sum = 1 + i;
            for (int j = even ? 2 : 3; j <= s && count < 5; j++) {
                if (i % j == 0) {
                    if (i / j != j) {
                        count += 2;
                        sum += j + i / j;
                    } else {
                        count++;
                        sum += j;
                    }
                }
            }
            if (count == 4) {
                res += sum;
            }
        }
        return res;
    }
}
