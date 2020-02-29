package algorithm.top100medium.QueueReconstructionbyHeight;

import java.util.Arrays;

public class Solution {
    int ans[][];

    public static void main(String[] args) {
        int a[][] = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        new Solution().reconstructQueue(a);
    }

    public int[][] reconstructQueue(int[][] people) {
        if (people == null) return null;
        ans = new int[people.length][2];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < 2; j++) {
                ans[i][j] = -1;
            }
        }
        sort(people, 0, people.length - 1);
        for (int i = 0; i < people.length; i++) {
            solve(people[i][0], people[i][1], ans);
        }
        return ans;
    }

    public void solve(int value1, int value2, int[][] ans) {
        int k = 0;
        for (int i = 0; i < ans.length; i++) {
            if (k == value2 && ans[i][0] == -1) {
                ans[i][0] = value1;
                ans[i][1] = value2;
                break;
            }
            if (ans[i][0] == -1 || ans[i][0] == value1) {
                k++;
            }
        }
    }

    public void sort(int[][] people, int start, int end) {
        if (start >= end) return;
        int first = start;
        int finish = end;
        int base = people[end][0];
        while (start < end) {
            while (people[start][0] <= base && start < end) start++;
            if (start < end) {
                people[start][0] = people[start][0] ^ people[end][0];
                people[start][1] = people[start][1] ^ people[end][1];
                people[end][0] = people[start][0] ^ people[end][0];
                people[end][1] = people[start][1] ^ people[end][1];
                people[start][0] = people[start][0] ^ people[end][0];
                people[start][1] = people[start][1] ^ people[end][1];
                end--;
            }
            while (people[end][0] >= base && start < end) end--;
            if (start < end) {
                people[start][0] = people[start][0] ^ people[end][0];
                people[start][1] = people[start][1] ^ people[end][1];
                people[end][0] = people[start][0] ^ people[end][0];
                people[end][1] = people[start][1] ^ people[end][1];
                people[start][0] = people[start][0] ^ people[end][0];
                people[start][1] = people[start][1] ^ people[end][1];
                start++;
            }
        }
        sort(people, first, start - 1);
        sort(people, start + 1, finish);
    }
}
