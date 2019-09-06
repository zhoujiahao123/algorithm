package algorithm.Greedy.course;

import java.util.ArrayList;

/**
 * 快速排序 平均时间复杂度nlogn，最多n*n
 * 
 * @author simoniu
 * 
 */
public class Sort {
	public static void SortByendTime(ArrayList<Things> thingsSorted,
			Integer start, Integer end) {
		if (start >= end) // 递归结束的条件
		{
			return;
		}
		Things key = thingsSorted.get(start); // 关键数据
		Integer i = start; // 最左边的游标
		Integer j = end; // 最右边的游标
		while (i < j) {
			while (j > i
					&& thingsSorted.get(j).getEndTime() >= key.getEndTime())// 当后面的值大于key时，不交换，继续向前走
			{
				j--;
			}
			if (j > i) {
				Things t = thingsSorted.get(i);
				thingsSorted.set(i, thingsSorted.get(j));
				thingsSorted.set(j, t);
			}
			while (i < j
					&& thingsSorted.get(i).getEndTime() <= key.getEndTime()) // 当前面的值小于等于key时，不交换，继续向后走
			{
				i++;
			}
			if (i < j) {
				Things t = thingsSorted.get(j);
				thingsSorted.set(j, thingsSorted.get(i));
				thingsSorted.set(i, t);
			}
		}
		SortByendTime(thingsSorted, start, j - 1); // 对前半部分递归
		SortByendTime(thingsSorted, j + 1, end); // 对后半部分递归
	}
}