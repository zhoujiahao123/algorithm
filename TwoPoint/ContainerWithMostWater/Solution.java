package algorithm.TwoPoint.ContainerWithMostWater;

public class Solution {
    int max = 0;

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        while (l < r) {
            max = Math.max((r - l) * Math.min(height[l], height[r]), max);
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }

    private void twoPoint(int start, int end, int[] height) {
        if (start >= end)
            return;
        max = Math.max((end - start) * Math.min(height[start], height[end]), max);
        if (height[start] > height[end]) {
            twoPoint(start, end - 1, height);
        } else if (height[start] < height[end]) {
            twoPoint(start + 1, end, height);
        } else {
            twoPoint(start + 1, end, height);
            twoPoint(start, end - 1, height);
        }
    }
}
