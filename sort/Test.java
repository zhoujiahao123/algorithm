package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static int[] numberGenerator(int maxNum, int count) {
        int[] res = new int[count];
        Random random = new Random();
        for (int i = 0; i < res.length; i++) {
            res[i] = random.nextInt(maxNum + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = numberGenerator(100000, 100000);
        int[] newArr = Arrays.copyOf(arr, arr.length);
        long timeShellSort1 = System.currentTimeMillis();
        ShellSort.ShellSort(arr,arr.length);
        long timeShellSort2 = System.currentTimeMillis();
        long timeQuicklySort1 = System.currentTimeMillis();
        Arrays.sort(newArr);
        long timeQuicklySort2 = System.currentTimeMillis();
        System.err.println("the timeShellSort : " + (timeShellSort2 - timeShellSort1));
        System.err.println("the timeQuicklySort1 : " + (timeQuicklySort2 - timeQuicklySort1));
    }
}
