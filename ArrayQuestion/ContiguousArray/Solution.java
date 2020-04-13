package algorithm.ArrayQuestion.ContiguousArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] a = {1, 0, 1, 0, 0, 0, 1, 1,1};
        new Solution().findMaxLength(a);
    }

    //暴力超时
    public int findMaxLength(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = (nums[0] == 0 ? -1 : 1);
        for (int i = 1; i < nums.length; i++) {
            //表示从第一个数开始到后面每一个数为终点能产生的0,1的个数差，-1:0,1:1;
            dp[i] = dp[i - 1] + (nums[i] == 0 ? -1 : 1);
        }
        int max = 0;
        for (int i = 0; i < dp.length - 1; i++) {
            for (int j = i + 1; j < dp.length; j++) {
                dp[j] = dp[j] - dp[i];
                if (dp[j] == 0 && (j - i > max)) max = j - i;
            }
        }
        return max;
    }

    public int findMaxLength1(int[] nums) {
        int max = 0;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0;i<nums.length;i++){
            count = count + (nums[i]==0?-1:1);
            if(map.containsKey(count)){
                max = Math.max(max,i -map.get(count) );
            }else{
                map.put(count,i);
            }
        }
        return max;
    }
}