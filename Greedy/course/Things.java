package algorithm.Greedy.course;

/**
 * �����
 * 
 * @author simoniu
 * 
 */
public class Things {

	// ʱ������Ϊ24Сʱ�ƣ���0-23
	private String name; // �ʼ�������
	private Integer startTime; // һ���ʼ�������ʱ��
	private Integer endTime; // ����ʱ�� (endTime - startTime
								// Ϊ���������������ʱ�䣬��endTime֮ǰ��������)

	public Things(Integer startTime, Integer endTime, String name) {
		this.endTime = endTime;
		this.startTime = startTime;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

}