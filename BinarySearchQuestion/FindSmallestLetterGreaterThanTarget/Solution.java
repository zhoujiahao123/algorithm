package BinarySearchQuestion.FindSmallestLetterGreaterThanTarget;

/**
 * 该函数功能在于求出一个已排序的数组中大于给定数target的最小的数.
 * 该问题可以引申出很多类似的问题，牢记解决方式。
 */
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int length = letters.length;
        int end = letters.length - 1;
        int mid = start;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (letters[mid] == target) {
                while (true) {
                    if (mid + 1 < length && letters[mid] == letters[mid + 1]) {
                        mid++;
                    } else {
                        break;
                    }
                }
                return letters[(mid + 1) % length];
            } else if (letters[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[(end + 1) % length];
    }
}