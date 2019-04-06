package MajorityElement;

import java.util.Arrays;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * 注意这道题还是会出现负数，用数组的方式会出现一定的问题，总结一下这种题的两种思路
 * 1.若不会出现负数，则利用数组的方式，用一个ans数组来记录出现的次数
 * 2.若出现负数，则排序，利用nums[i] 是否等于nums[i+1]来判断问题
 */
class Solution {
    public int majorityElement(int[] nums) {
        //利用第二种方式，先排序
        Arrays.sort(nums);
        //判断出现次数
        int result = 1;
        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i] == nums[i + 1]) {
                result++;
            } else {
                //满足题目要求时返回
                if (result > nums.length / 2) {
                    return nums[i];
                }
                result = 1;
            }
        }
        //注意这里返回的数据，因为循环是循环到了倒数第二个数据，若最后一个数和倒数第二个数仍旧相同，则应当在最后来返回这个数据.
        return nums[nums.length-1];
    }
}