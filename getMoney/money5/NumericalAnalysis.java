package algorithm.getMoney.money5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumericalAnalysis {

    public static void showNumerical(List<Integer> list){
        int max = -1;
        int min = Integer.MAX_VALUE;
        double ave = 0.0;
        int sum = 0;
        for(int i = 0;i<list.size();++i){
            max = Math.max(max,list.get(i));
            min = Math.min(min,list.get(i));
            sum += list.get(i);
        }
        ave = (double) sum/list.size();
        System.out.println("the max value : "+max);
        System.out.println("the min value£º"+min);
        System.out.println("the average£º"+ave);
    }

    public static void main(String[] args) {
        System.out.println("Please enter the list, ending with a negative number");
        Scanner input = new Scanner(System.in);
        int temp = input.nextInt();
        List<Integer> list = new ArrayList<>();
        while (temp >= 0){
            list.add(temp);
            temp = input.nextInt();
        }
        showNumerical(list);
    }
}