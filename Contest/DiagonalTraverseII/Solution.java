package algorithm.Contest.DiagonalTraverseII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        List<Integer> list3 = new ArrayList<>();
        list3.add(7);
        list3.add(8);
        list3.add(9);
        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        new Solution().findDiagonalOrder(list);
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int len = 0;
        int rowNum = nums.size(), column = 0;
        //遍历获取长和宽
        for (int i = 0; i < rowNum; i++) {
            int size = nums.get(i).size();
            len += size;
            column = Math.max(column, size);
        }
        int[] res = new int[len];
        int k = 0;//res的指针
        //i:当前行+列应为i
        for (int i = 0; i < rowNum + column; i++) {
            //当行取j的时候
            for (int j = Math.min(rowNum - 1, i); j >= 0; --j) {
                List<Integer> list = nums.get(j);
                if (list.size() > (i - j)) {
                    res[k++] = list.get(i - j);
                }
            }
        }
        return res;
    }

}