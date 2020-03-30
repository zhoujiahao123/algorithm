package algorithm.Contest.FindLuckyIntegerinanArray;

class Solution {
    public int findLucky(int[] arr) {
        int a[] = new int[501];

        for (int i = 0; i < arr.length; i++) {
            a[arr[i]]++;
        }
        int res = -1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == i) {
                res = i;
            }
        }
        return res;
    }
}