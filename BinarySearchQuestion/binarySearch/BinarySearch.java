package algorithm.BinarySearchQuestion.binarySearch;

public class BinarySearch {
    public static int search(int a[], int target) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] > target) {
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,5,5,8,9,10};
        System.out.println(search(a,4));
    }
}
