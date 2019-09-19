package algorithm.DpQuestion.snapsack;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<Things> bestSolution = new ArrayList<>();
        Things[] things = new Things[]{new Things(2, 13),
                new Things(1, 10), new Things(3, 24), new Things(2, 15),
                new Things(4, 28), new Things(5, 33), new Things(3, 20),
                new Things(1, 8)};
        int bagWeight = 12;
        int bestValue[][] = new int[things.length + 1][bagWeight + 1];
        solve(bestValue, things);
        for (int i = 0; i < bestValue.length; i++) {
            for (int j = 0; j < bestValue[i].length; j++) {
                System.out.printf("%-5d", bestValue[i][j]);
            }
            System.out.println();
        }
        //是哪些物品被选择了
        for (int i = bestValue.length - 1; i >= 0; i--) {
            if (bestValue[i][bagWeight] > bestValue[i - 1][bagWeight]) {
                bestSolution.add(things[i - 1]);
                bagWeight -= things[i - 1].getWeight();
            }
            if (bagWeight == 0)
                break;
        }
        for (int i = bestSolution.size() - 1; i >= 0; i--) {
            System.out.println(bestSolution.get(i).toString());
        }
    }

    public static void solve(int bestValue[][], Things[] things) {
        for (int i = 0; i < bestValue.length; i++) {
            for (int j = 0; j < bestValue[0].length; j++) {
                if (i == 0 || j == 0) {
                    bestValue[i][j] = 0;
                } else {
                    if (j >= things[i - 1].getWeight()) {
                        bestValue[i][j] = Math.max(bestValue[i - 1][j], things[i - 1].getValue() + bestValue[i - 1][j - things[i - 1].getWeight()]);
                    } else {
                        bestValue[i][j] = bestValue[i - 1][j];
                    }
                }
            }
        }
    }
}
