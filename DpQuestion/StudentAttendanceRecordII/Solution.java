package algorithm.DpQuestion.StudentAttendanceRecordII;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int count = 0;

    public static void main(String[] args) {
        new Solution().checkRecord(2);
    }

    public int checkRecord(int n) {
        backtrace(n, new ArrayList<Integer>(), 0);
        return count;
    }

    public void backtrace(int n, List<Integer> res, int pos) {
        if (pos == n) {
            count++;
            return;
        }
        for (int j = 1; j <= 3; j++) {
            if (j == 1) {
                if (res.contains(j)) {
                    continue;
                }
            }
            if (j == 2) {
                if (res.size() - 1 > 0 && res.get(res.size() - 1) == 2 && res.get(res.size() - 2) == 2) {
                    continue;
                }
            }
            res.add(j);
            backtrace(n, res, pos + 1);
            res.remove(res.size() - 1);
        }
    }
}