package algorithm.Greedy.course;

import java.util.ArrayList;
import java.util.Iterator;

public class GreedyTest {
	public static ArrayList<Car> cars = new ArrayList<Car>();

	public static void main(String[] args) {
		ArrayList<Things> thingsList = new ArrayList<Things>(); // ����װ����ģ�����
		/****** ������11����� ****/
		Things thing8 = new Things(8, 11, "�ɼ�8");
		thingsList.add(thing8);
		Things thing9 = new Things(8, 12, "�ɼ�9");
		thingsList.add(thing9);
		Things thing10 = new Things(2, 13, "�ɼ�10");
		thingsList.add(thing10);
		Things thing11 = new Things(12, 14, "�ɼ�11");
		thingsList.add(thing11);
		Things thing1 = new Things(1, 4, "�ɼ�1");
		thingsList.add(thing1);
		Things thing2 = new Things(3, 5, "�ɼ�2");
		thingsList.add(thing2);
		Things thing3 = new Things(0, 6, "�ɼ�3");
		thingsList.add(thing3);
		Things thing4 = new Things(5, 7, "�ɼ�4");
		thingsList.add(thing4);
		Things thing5 = new Things(3, 8, "�ɼ�5");
		thingsList.add(thing5);
		Things thing6 = new Things(5, 9, "�ɼ�6");
		thingsList.add(thing6);
		Things thing7 = new Things(6, 10, "�ɼ�7");
		thingsList.add(thing7);
		/*** �������ɼ�������ʱ������ź��� ***/
		System.out.print("����ǰ��");
		for (Things t : thingsList) {
			System.out.print(t.getName()+":"+t.getStartTime()+"-"+t.getEndTime() + ",");
		}
		Sort.SortByendTime(thingsList, 0, thingsList.size() - 1); // �����㷨
		System.out.print("\n�����");
		for (Things t : thingsList) {
			System.out.print(t.getName()+":"+t.getStartTime()+"-"+t.getEndTime() + ",");
		}
		GreedySelect(thingsList); // ����̰���㷨
		System.out.println("\n������Ҫ" + cars.size() + "����");
		int i = 1;
		for (Car car : cars) {
			System.out.println("��" + i + "����װ���ɼ���:");
			for (Things t : car.getThingsList()) {
				System.out.print(t.getName() + ",");
			}
			System.out.println("\n");
			i++;
		}
	}

	public static void GreedySelect(ArrayList<Things> thingsList) {
		Car car = new Car();
		Integer middleTime = thingsList.get(0).getEndTime();
		car.addThing(thingsList.get(0));
		thingsList.remove(0);
		cars.add(car);
		/*
		 * for(int i = 0;i<thingsList.size();i++) {
		 * if(middleTime<=thingsList.get(i).getStartTime()) { middleTime =
		 * thingsList.get(i).getEndTime(); car.addThing(thingsList.get(i));
		 * thingsList.remove(i); i--; } }
		 */
		for (Iterator<Things> t = thingsList.iterator(); t.hasNext();) // ����ע�͵�forѭ�������ֵ����������У���̬ɾ�������е�Ԫ��
		{
			Things tt = t.next();
			if (middleTime <= tt.getStartTime()) {
				middleTime = tt.getEndTime();
				car.addThing(tt);
				t.remove();
			}
		}
		if (thingsList.size() != 0) // �ݹ�
		{
			GreedySelect(thingsList);
		}
	}
}