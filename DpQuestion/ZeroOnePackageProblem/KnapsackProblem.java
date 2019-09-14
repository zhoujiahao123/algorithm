package algorithm.DpQuestion.ZeroOnePackageProblem;

import java.util.ArrayList;

//�����㷨��
public class KnapsackProblem {

	/** ָ������ */
	private Knapsack[] bags;

	/** �ܳ��� */
	private int totalWeight;

	/** ������������ */
	private int n;

	/** ǰ n ���������ܳ���Ϊ totalWeight ������ֵ���� */
	private int[][] bestValues;

	/** ǰ n ���������ܳ���Ϊ totalWeight ������ֵ */
	private int bestValue;

	/** ǰ n ���������ܳ���Ϊ totalWeight �����Ž����Ʒ��� */
	private ArrayList<Knapsack> bestSolution;

	public KnapsackProblem(Knapsack[] bags, int totalWeight) {
		this.bags = bags;
		this.totalWeight = totalWeight;
		this.n = bags.length;
		if (bestValues == null) {
			bestValues = new int[n + 1][totalWeight + 1];
		}
	}

	/**
	 * ���ǰ n �������������ܳ���Ϊ totalWeight �µı�������
	 * 
	 */
	public void solve() {

		System.out.println("����������");
		for (Knapsack b : bags) {
			System.out.println(b);
		}
		System.out.println("�����ܳ���: " + totalWeight);

		// �������ֵ
		for (int j = 0; j <= totalWeight; j++) {
			for (int i = 0; i <= n; i++) {

				if (i == 0 || j == 0) {
					bestValues[i][j] = 0;
				} else {
					// ����� i ����Ʒ���������ܳ���j�������Ž������ǰ i-1 ����Ʒ�У�
					// ע�⣺�� i ����Ʒ�� bags[i-1]
					if (j < bags[i - 1].getWeight()) {
						bestValues[i][j] = bestValues[i - 1][j];
					} else {
						// ����� i ����Ʒ�������ܳ��أ������Ž�Ҫô�ǰ����� i ����Ʒ�����Ž⣬
						// Ҫô�ǲ������� i ����Ʒ�����Ž⣬ ȡ�������ֵ����������˷������۷�
						// �� i ����Ʒ������ iweight �ͼ�ֵ ivalue
						int iweight = bags[i - 1].getWeight();
						int ivalue = bags[i - 1].getValue();
						bestValues[i][j] = Math.max(bestValues[i - 1][j],
								ivalue + bestValues[i - 1][j - iweight]);
					} // else
				} // else
			} // for
		} // for

		// ��ⱳ�����
		if (bestSolution == null) {
			bestSolution = new ArrayList<Knapsack>();
		}
		int tempWeight = totalWeight;
		for (int i = n; i >= 1; i--) {
			if (bestValues[i][tempWeight] > bestValues[i - 1][tempWeight]) {
				bestSolution.add(bags[i - 1]); // bags[i-1] ��ʾ�� i ������
				tempWeight -= bags[i - 1].getWeight();
			}
			if (tempWeight == 0) {
				break;
			}
		}
		bestValue = bestValues[n][totalWeight];
	}

	/**
	 * ���ǰ n �������� �ܳ���Ϊ totalWeight �ı�����������Ž�ֵ ���������� �����ȵ��� solve ����
	 * 
	 */
	public int getBestValue() {
		return bestValue;
	}

	/**
	 * ���ǰ n �������� �ܳ���Ϊ totalWeight �ı�����������Ž�ֵ���� ���������� �����ȵ��� solve ����
	 * 
	 */
	public int[][] getBestValues() {

		return bestValues;
	}

	/**
	 * ���ǰ n �������� �ܳ���Ϊ totalWeight �ı�����������Ž�ֵ���� ���������� �����ȵ��� solve ����
	 * 
	 */
	public ArrayList<Knapsack> getBestSolution() {
		return bestSolution;
	}

}
