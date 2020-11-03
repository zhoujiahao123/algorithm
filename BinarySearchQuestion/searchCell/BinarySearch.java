package algorithm.BinarySearchQuestion.searchCell;

public class BinarySearch {
    public static int search(int a[], int target) {
        int lo = 0, hi = a.length - 1;
        int greaterThanPos = -1,lessThanPos = -1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        greaterThanPos = lo;
        lo = 0;
        hi = a.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] >= target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        lessThanPos = hi;
        return greaterThanPos - lessThanPos - 1;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 5, 7,7,7,7,7,7, 11, 13, 17};
        System.out.println(search(array,7));
    }
}
