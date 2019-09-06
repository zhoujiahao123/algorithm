package algorithm.Greedy.course;

import java.util.ArrayList;

/**
 * �������� ƽ��ʱ�临�Ӷ�nlogn�����n*n
 * 
 * @author simoniu
 * 
 */
public class Sort {
	public static void SortByendTime(ArrayList<Things> thingsSorted,
			Integer start, Integer end) {
		if (start >= end) // �ݹ����������
		{
			return;
		}
		Things key = thingsSorted.get(start); // �ؼ�����
		Integer i = start; // ����ߵ��α�
		Integer j = end; // ���ұߵ��α�
		while (i < j) {
			while (j > i
					&& thingsSorted.get(j).getEndTime() >= key.getEndTime())// �������ֵ����keyʱ����������������ǰ��
			{
				j--;
			}
			if (j > i) {
				Things t = thingsSorted.get(i);
				thingsSorted.set(i, thingsSorted.get(j));
				thingsSorted.set(j, t);
			}
			while (i < j
					&& thingsSorted.get(i).getEndTime() <= key.getEndTime()) // ��ǰ���ֵС�ڵ���keyʱ�������������������
			{
				i++;
			}
			if (i < j) {
				Things t = thingsSorted.get(j);
				thingsSorted.set(j, thingsSorted.get(i));
				thingsSorted.set(i, t);
			}
		}
		SortByendTime(thingsSorted, start, j - 1); // ��ǰ�벿�ֵݹ�
		SortByendTime(thingsSorted, j + 1, end); // �Ժ�벿�ֵݹ�
	}
}