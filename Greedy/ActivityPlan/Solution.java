package algorithm.Greedy.ActivityPlan;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Activity> activityList = new ArrayList<>();

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }
    public void addActivity(Activity activity){
        activityList.add(activity);
    }
}
