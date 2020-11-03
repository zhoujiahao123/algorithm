package algorithm.Stack.Hanota;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(0);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        hanota(list,list1,list2);
    }
    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        process(A.size(),A,B,C,A,C);
    }
    public static void process(int n,List<Integer> A, List<Integer> B, List<Integer> C,List<Integer> from ,List<Integer> to) {
        if(n == 1){
            to.add(from.remove(0));
            return;
        }
        if(from == B || to == B){
            List<Integer> another = from == A?C:A;
            Integer i = from.remove(0);
            process(n-1,A,B,C,from,another);
            to.add(i);
            process(n-1,A,B,C,another,to);
        }else{
            Integer i = from.remove(0);
            System.out.println(i+" i ");
            process(n-1,A,B,C,from,B);
            for(int j = 0;j<B.size();j++) System.out.println(B.get(j)+" B ");
            to.add(i);
            process(n-1,A,B,C,B,to);
            for(int j = 0;j<B.size();j++) System.out.println(to.get(j)+" to ");
            System.out.println("  ");
        }
    }
}
