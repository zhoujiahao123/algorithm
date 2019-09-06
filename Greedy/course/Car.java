package algorithm.Greedy.course;

import java.util.ArrayList;

/**
 * 派送货件的小车
 * 
 * @author simoniu
 * 
 */
public class Car {
	private ArrayList<Things> thingsList = new ArrayList<Things>();// 车子一天跑的趟数

	public ArrayList<Things> getThingsList() {
		return thingsList;
	}

	public void setThingsList(ArrayList<Things> thingsList) {
		this.thingsList = thingsList;
	}

	public Integer addThing(Things thing) // 车子跑一趟, 返回跑了多少趟，包括此趟
	{
		thingsList.add(thing);
		return thingsList.size();
	}
}
