package algorithm.top100medium.Searcha2DMatrixII;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (binarySearch(matrix[i], target) != -1) return true;
        }
        return false;
    }

    public int binarySearch(int[] a, int target) {
        int start = 0, end = a.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
