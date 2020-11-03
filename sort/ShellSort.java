package algorithm.sort;

public class ShellSort {

    public static void ShellSort(int array[], int length) {
        int d = length / 2;   //设置希尔排序的增量
        int i;
        int j;
        while (d >= 1) {
            for (i = d; i < length; i++) {
                j = i - d;
                while (j >= 0 && array[j] < array[i]) {
                    array[j + d] = array[j];
                    j = j - d;
                }
                array[j + d] = array[i];
            }
            d = d / 2;
        }
    }
}
