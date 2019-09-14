package algorithm.Greedy.ActivityPlan.planB;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ����������������Ҫ�������н����ͬ��������ֻ��Ҫ��������һ���������˿��Բ�����list����װ��solution
 */
public class Test {

    public static void main(String[] args) {
        List<Activity> activityList = new ArrayList<>();
        Solution solution = new Solution();
        //������ʱ���ź������ǽ����������Ĺؼ���
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
        while (activityList.size() != 0) {
            int time = activityList.get(0).getEndTime();
            solution.addActivity(activityList.get(0));
            activityList.remove(0);
            removeUnsuitable(activityList,time);
        }
        System.out.println("���Ž����£�");
        for(Iterator<Activity> t = solution.getActivityList().iterator();t.hasNext();){
            Activity activity = t.next();
            System.out.print(activity.getName()+"   ");
        }
    }

    /**
     * �Ƴ�������ѡ���Ļʱ���ͻ�Ļ
     *
     * @param activityList
     * @param time         ��ѡ���Ļ�Ľ���ʱ��
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
