package BestTimetoBuyandSellStock;
/**
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * 该做法太麻烦，又耗费时间又耗费空间，只能算是提供一种思路。
 */

import java.util.*;

class Solution {
    //使用Map出现很大的失误：map中不能有相同的key，但是本题当 input= [1,4,1,4,3,1]时出现问题，
    // 注意用map + sort 的时候一定要注意是否会出现相同的key这一问题
    List<Bianhao> list = new ArrayList<>();
    public int maxProfit(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            list.add(new Bianhao(prices[i],i));
        }
        Collections.sort(list);
        Arrays.sort(prices);
        return solve(prices, 0, prices.length - 1);
    }

    public int solve(int[] prices, int start, int end) {
        if (start >= end) return 0;
        //如果最大和最小刚好满足条件，就是最简单的情况
        if (list.get(start).getKey()<list.get(end).getKey()) {
            return prices[end] - prices[start];
        }
        return Math.max(solve(prices, start + 1, end), solve(prices, start, end - 1));
    }
}

class Bianhao implements Comparable<Bianhao>{
    private Integer value;
    private int key;

    public Bianhao(Integer value, int key) {
        this.value = value;
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    //升序
    @Override
    public int compareTo(Bianhao o) {
        return this.getValue().compareTo(o.getValue());
    }
    public Integer getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}