package algorithm.sort;

import java.util.Arrays;

public class ShellSort {

    public static void shellSort1(int[] arr) {
        int gap = arr.length / 2;
        while (gap != 0) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while (j - gap >= 0 && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                if (j != i) arr[j] = temp;
            }
            gap /= 2;
        }
        for(int i : arr) System.out.println(i);
    }
}
