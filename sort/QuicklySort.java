package algorithm.sort;

public class QuicklySort {

    public static void sort(int arr[]) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int arr[], int start, int end) {
        if (start >= end) return;
        int partition = quicklySort(arr, start, end);
        sort(arr, start, partition - 1);
        sort(arr, partition + 1, end);
    }

    public static int quicklySort(int arr[], int start, int end) {
        int base = arr[end];
        while (start < end) {
            while (start < end && base >= arr[start]) start++;
            if (start < end) {
                arr[start] = arr[start] ^ arr[end];
                arr[end] = arr[start] ^ arr[end];
                arr[start] = arr[start] ^ arr[end];
                end--;
            }
            while (start < end && base <= arr[end]) end--;
            if (start < end) {
                arr[start] = arr[start] ^ arr[end];
                arr[end] = arr[start] ^ arr[end];
                arr[start] = arr[start] ^ arr[end];
                start++;
            }
        }
        return start;
    }
}
