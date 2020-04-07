package algorithm.CountingElements;

import java.util.Arrays;

public class Solution {
    public int countElements(int[] arr) {
        Arrays.sort(arr);
        int nowElement = 1;//µ±Ç°Êý
        int total = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                nowElement++;
            } else if (arr[i] == arr[i - 1] + 1) {
                total += nowElement;
                nowElement = 1;
            } else {
                nowElement = 1;
            }
        }
        return total;
    }
}
