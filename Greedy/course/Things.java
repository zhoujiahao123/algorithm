package algorithm.Greedy.course;

/**
 * 快件类
 * 
 * @author simoniu
 * 
 */
public class Things {

	// 时间设置为24小时制，从0-23
	private String name; // 邮件的名字
	private Integer startTime; // 一批邮件过来的时间
	private Integer endTime; // 结束时间 (endTime - startTime
								// 为送完这批快件所需时间，在endTime之前必须送完)

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