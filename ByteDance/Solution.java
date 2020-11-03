package algorithm.ByteDance;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] a = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
            total += a[i];
        }
        int res = 0;
        for (int i = 1; i * k <= total; i++) {
            res += subarraySum(a,k*i);
        }
        System.out.println(res);
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
