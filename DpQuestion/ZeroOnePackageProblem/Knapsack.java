package algorithm.DpQuestion.ZeroOnePackageProblem;

//物品类
public class Knapsack {

	/** 物品重量 */
	private int weight;

	/** 物品价值 */
	private int value;

	/***
	 * 构造器
	 */
	public Knapsack(int weight, int value) {
		this.value = value;
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return "[weight: " + weight + " " + "value: " + value + "]";
	}
}
