package algorithm.Greedy.course;

import java.util.ArrayList;

/**
 * ���ͻ�����С��
 * 
 * @author simoniu
 * 
 */
public class Car {
	private ArrayList<Things> thingsList = new ArrayList<Things>();// ����һ���ܵ�����

	public ArrayList<Things> getThingsList() {
		return thingsList;
	}

	public void setThingsList(ArrayList<Things> thingsList) {
		this.thingsList = thingsList;
	}

	public Integer addThing(Things thing) // ������һ��, �������˶����ˣ���������
	{
		thingsList.add(thing);
		return thingsList.size();
	}
}
