package TwoSum;

import java.util.Arrays;
import java.util.HashMap;

public class Solution1 {
    public int[] twosum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        Arrays.sort(numbers);
        int startIndex = 0, endIndex = numbers.length - 1;
        while (startIndex < endIndex) {
            if (numbers[startIndex] + numbers[endIndex] == target) {
                int num1 = numbers[startIndex];
                int num2 = numbers[endIndex];
                return new int[]{map.get(num1), map.get(num2)};
            } else if (numbers[startIndex] + numbers[endIndex] < target) {
                startIndex++;
            } else {
                endIndex--;
            }
        }
        return null;
    }
}
