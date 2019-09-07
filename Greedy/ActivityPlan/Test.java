package algorithm.Greedy.ActivityPlan;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Solution> solutionList = new ArrayList<>();
        List<Activity> activityList = new ArrayList<>();
        activityList.add(new Activity("�1", 1, 4));
        activityList.add(new Activity("�2", 3, 5));
        activityList.add(new Activity("�3", 0, 6));
        activityList.add(new Activity("�4", 5, 7));
        activityList.add(new Activity("�5", 3, 8));
        activityList.add(new Activity("�6", 5, 9));
        activityList.add(new Activity("�7", 6, 10));
        activityList.add(new Activity("�8", 8, 11));
        activityList.add(new Activity("�9", 8, 12));
        activityList.add(new Activity("�10", 2, 13));
        activityList.add(new Activity("�11", 12, 14));
        greedy(solutionList,activityList);
        for(Iterator<Solution> t = solutionList.iterator();t.hasNext();){
            Solution solution = t.next();
            for(Iterator<Activity> tt = solution.getActivityList().iterator();tt.hasNext();){
                Activity activity = tt.next();
                System.out.print(activity.getName()+" ");
            }
            System.out.println();
        }
    }

    public static void greedy(List<Solution> solutionList, List<Activity> activityList) {
        if(activityList.size() == 0){
            return;
        }
        Solution solution = new Solution();
        int endTime = activityList.get(0).getEndTime();
        solution.addActivity(activityList.get(0));
        solutionList.add(solution);
        activityList.remove(0);
        for (Iterator<Activity> t = activityList.iterator(); t.hasNext(); ) {
            Activity activity = t.next();
            if (activity.getStartTime() >= endTime) {
                endTime = activity.getEndTime();
                solution.addActivity(activity);
                t.remove();
            }
        }
        if(activityList.size() !=0){
            greedy(solutionList, activityList);
        }
    }
}
