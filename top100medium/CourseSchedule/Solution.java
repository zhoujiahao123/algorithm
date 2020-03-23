package algorithm.top100medium.CourseSchedule;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] preList = new List[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            if (preList[prerequisites[i][0]] == null) preList[prerequisites[i][0]] = new ArrayList<>();
            preList[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        boolean[] isArranged = new boolean[numCourses], isChoose = new boolean[numCourses];
        for (int i = 0; i < preList.length; i++) {
            if (preList[i] == null) continue;
            if (!isArranged[i]) {
                isChoose[i] = true;
                if (!judgeCanFinish(preList, preList[i], isArranged, isChoose, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean judgeCanFinish(List<Integer>[] preList, List<Integer> list, boolean[] isArranged, boolean[] isChoose, int pos) {
        for (int i = 0; i < list.size(); i++) {
            if (preList[list.get(i)] == null) {
                isArranged[list.get(i)] = true;
            } else {
                if (isChoose[list.get(i)] && !isArranged[list.get(i)]) {
                    return false;
                }
                isChoose[list.get(i)] = true;
                if (!judgeCanFinish(preList, preList[list.get(i)], isArranged, isChoose, list.get(i))) {
                    return false;
                }
            }
        }
        isArranged[pos] = true;
        return true;
    }
}
