package algorithm.Greedy.CourseScheduleIII;

public class Solution {
    int count = 0;

    public static void main(String[] args) {
        int courses[][] = new int[][]{{7,16},{2,3},{3,12},{3,14},{10,19},{10,16},{6,8},{6,11},{3,13},{6,16}};
        System.out.println(new Solution().scheduleCourse(courses));
    }

    public int scheduleCourse(int[][] courses) {
        init(courses);
        //������ʱ������
        quickSort(courses, 0, courses.length - 1);
        //̰����ѡ
        return chooseActivity(courses);
    }

    private void delete(int[][] courses, int pos) {
        for (int i = pos; i < courses.length - 1; i++) {
            courses[i][0] = courses[i + 1][0];
            courses[i][1] = courses[i + 1][1];
        }
    }

    /**
     * ɾ��������Ҫ�������
     * ������s = d����ôɾ��������ݣ�����count++;
     * ������s > d ,��ôɾ��������ݲ��Ҳ��ı�count
     *
     * @param courses
     */
    private void init(int[][] courses) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i][0] == courses[i][1]) {
                count++;
                delete(courses, i);
            } else if (courses[i][0] > courses[i][1]) {
                delete(courses, i);
            }
        }
    }

    /**
     * ��������
     *
     * @param courses ���ս���ʱ������
     */
    private void quickSort(int[][] courses, int begin, int finish) {
        int start = begin;
        int end = finish;
        if (start >= end) {
            return;
        }
        while (start < end) {
            int base = courses[end][1];
            while (start < end && courses[start][1] <= base) start++;
            if (start < end) {
                courses[end][1] = courses[start][1] ^ courses[end][1];
                courses[end][0] = courses[start][0] ^ courses[end][0];
                courses[start][1] = courses[start][1] ^ courses[end][1];
                courses[start][0] = courses[start][0] ^ courses[end][0];
                courses[end][1] = courses[start][1] ^ courses[end][1];
                courses[end][0] = courses[start][0] ^ courses[end][0];
                end--;
            }
            while (start < end && courses[end][1] >= base) end--;
            if (start < end) {
                courses[end][1] = courses[start][1] ^ courses[end][1];
                courses[end][0] = courses[start][0] ^ courses[end][0];
                courses[start][1] = courses[start][1] ^ courses[end][1];
                courses[start][0] = courses[start][0] ^ courses[end][0];
                courses[end][1] = courses[start][1] ^ courses[end][1];
                courses[end][0] = courses[start][0] ^ courses[end][0];
                start++;
            }
        }
        int partition = start;
        quickSort(courses, begin, partition - 1);
        quickSort(courses, partition + 1, finish);
    }

    public int chooseActivity(int[][] courses) {
        int lastFinishTime = courses[0][1];
        count++;
        for (int i = 1; i < courses.length; i++) {
            if (lastFinishTime <= courses[i][0]) {
                count++;
                lastFinishTime = courses[i][1];
            }
        }
        return count;
    }
}
