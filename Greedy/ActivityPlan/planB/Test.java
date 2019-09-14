package algorithm.Greedy.ActivityPlan.planB;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 该问题与快递问题需要给出所有结果不同，该问题只需要给出其中一个结果，因此可以不采用list集合装载solution
 */
public class Test {

    public static void main(String[] args) {
        List<Activity> activityList = new ArrayList<>();
        Solution solution = new Solution();
        //按结束时间排好序，这是解决这类问题的关键。
        activityList.add(new Activity("活动1", 1, 4));
        activityList.add(new Activity("活动2", 3, 5));
        activityList.add(new Activity("活动3", 0, 6));
        activityList.add(new Activity("活动4", 5, 7));
        activityList.add(new Activity("活动5", 3, 8));
        activityList.add(new Activity("活动6", 5, 9));
        activityList.add(new Activity("活动7", 6, 10));
        activityList.add(new Activity("活动8", 8, 11));
        activityList.add(new Activity("活动9", 8, 12));
        activityList.add(new Activity("活动10", 2, 13));
        activityList.add(new Activity("活动11", 12, 14));
        while (activityList.size() != 0) {
            int time = activityList.get(0).getEndTime();
            solution.addActivity(activityList.get(0));
            activityList.remove(0);
            removeUnsuitable(activityList,time);
        }
        System.out.println("最优解如下：");
        for(Iterator<Activity> t = solution.getActivityList().iterator();t.hasNext();){
            Activity activity = t.next();
            System.out.print(activity.getName()+"   ");
        }
    }

    /**
     * 移除所有与选定的活动时间冲突的活动
     *
     * @param activityList
     * @param time         ：选定的活动的结束时间
     */
    public static void removeUnsuitable(List<Activity> activityList, int time) {
        for(Iterator<Activity> t = activityList.iterator();t.hasNext();){
            Activity activity = t.next();
            if(activity.getStartTime()<time){
                t.remove();
            }
        }
    }

}
