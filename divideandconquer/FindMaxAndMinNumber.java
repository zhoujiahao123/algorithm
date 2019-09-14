package algorithm.divideandconquer;

/**
 * 查找未排序数组中最大的数和最小的数
 */
public class FindMaxAndMinNumber {
    int max;
    int min;

    public static void main(String[] args) {
        FindMaxAndMinNumber fm = new FindMaxAndMinNumber();
        int a[] = {1,2,5,7,9,6,5,4,2,58,4,-10};
        fm.max = a[0];
        fm.min = a[0];
        fm.solve(a, 0, a.length - 1);
        System.out.print("the max is :" + fm.max);
        System.out.print("the min is :" + fm.min);
    }

    public void solve(int a[], int start, int end) {
        int mid;
        if (end - start <= 1) {
            if (a[end] > a[start]) {
                max = Math.max(a[end], max);
                min = Math.min(a[start], min);
            } else {
                max = Math.max(a[start], max);
                min = Math.min(a[end], min);
            }
            return;
        }
        mid = start + (end - start) / 2;
        solve(a, start, mid);
        solve(a, mid + 1, end);
    }
}
