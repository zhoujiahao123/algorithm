package algorithm.Greedy.course;

import java.util.ArrayList;
import java.util.Iterator;

public class GreedyTest {
	public static ArrayList<Car> cars = new ArrayList<Car>();

	public static void main(String[] args) {
		ArrayList<Things> thingsList = new ArrayList<Things>(); // 用来装快件的，无序
		/****** 输入了11批快件 ****/
		Things thing8 = new Things(8, 11, "派件8");
		thingsList.add(thing8);
		Things thing9 = new Things(8, 12, "派件9");
		thingsList.add(thing9);
		Things thing10 = new Things(2, 13, "派件10");
		thingsList.add(thing10);
		Things thing11 = new Things(12, 14, "派件11");
		thingsList.add(thing11);
		Things thing1 = new Things(1, 4, "派件1");
		thingsList.add(thing1);
		Things thing2 = new Things(3, 5, "派件2");
		thingsList.add(thing2);
		Things thing3 = new Things(0, 6, "派件3");
		thingsList.add(thing3);
		Things thing4 = new Things(5, 7, "派件4");
		thingsList.add(thing4);
		Things thing5 = new Things(3, 8, "派件5");
		thingsList.add(thing5);
		Things thing6 = new Things(5, 9, "派件6");
		thingsList.add(thing6);
		Things thing7 = new Things(6, 10, "派件7");
		thingsList.add(thing7);
		/*** 给所有派件按结束时间递增排好序 ***/
		System.out.print("排序前：");
		for (Things t : thingsList) {
			System.out.print(t.getName()+":"+t.getStartTime()+"-"+t.getEndTime() + ",");
		}
		Sort.SortByendTime(thingsList, 0, thingsList.size() - 1); // 排序算法
		System.out.print("\n排序后：");
		for (Things t : thingsList) {
			System.out.print(t.getName()+":"+t.getStartTime()+"-"+t.getEndTime() + ",");
		}
		GreedySelect(thingsList); // 进行贪心算法
		System.out.println("\n最少需要" + cars.size() + "辆车");
		int i = 1;
		for (Car car : cars) {
			System.out.println("第" + i + "辆车装的派件有:");
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
		for (Iterator<Things> t = thingsList.iterator(); t.hasNext();) // 上面注释的for循环和这种迭代方法都行，动态删除容器中的元素
		{
			Things tt = t.next();
			if (middleTime <= tt.getStartTime()) {
				middleTime = tt.getEndTime();
				car.addThing(tt);
				t.remove();
			}
		}
		if (thingsList.size() != 0) // 递归
		{
			GreedySelect(thingsList);
		}
	}
}