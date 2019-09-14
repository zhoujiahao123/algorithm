package algorithm.divideandconquer;

/**
 * 归并算法：
 * 先递归分解数组
 * 再合并有序数组
 */
public class MergeSort {


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        //生成随机数组
        int number = 10000;
        int temp[] = new int[number];
        int a[] = new int[number];
        for (int i = 0; i < number; i++) {
            a[i] = (int) (Math.random() * number);
        }
        mergeSort.mergeSort(0, a.length - 1, a, temp);
        for (int i = 0; i < number; i++) {
            System.out.print(a[i] + "->");
        }
    }


    public void mergeSort(int first, int end, int a[], int temp[]) {
        if (first < end) {
            int mid = (first + end) / 2;
            mergeSort(first, mid, a, temp);
            mergeSort(mid + 1, end, a, temp);
            mergeArray(a, first, mid, end, temp);
        }
    }

    /**
     * 合并两个数组，比较两个数组的第一个数，谁小就取谁，然后再从数据中去掉已经选择了的，然后再进行比较。
     * 如果某个数组为空，则直接取另一个数组就行
     *
     * @param a
     * @param first
     * @param mid
     * @param end
     * @param temp
     */
    public void mergeArray(int a[], int first, int mid, int end, int temp[]) {
        //其中合并的两个数组为a[first .. mid]  a[mid+1 end]
        int i = first, m = mid, j = mid + 1, n = end, k = 0;
        //先把两个数组中每个小的数放入一个临时数组中
        while (i <= m && j <= n) {
            if (a[i] < a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }
        while (i <= m) {
            temp[k++] = a[i++];
        }
        while (j <= n) {
            temp[k++] = a[j++];
        }
        for (i = 0; i < k; i++) {
            //注意这里是从first + i 开始的
            a[first + i] = temp[i];
        }
    }
}
