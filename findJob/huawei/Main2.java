package algorithm.findJob.huawei;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] a = new int[n];
            for(int i = 0;i<n;++i){
                a[i] = in.nextInt();
            }
            Deque<Integer> stack = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            dfs(a,0,n,stack,list);
        }
    }
    public static void dfs(int[] a,int pos,int n,Deque<Integer> stack,List<Integer> list){
        if(pos == n){
            for(int i = 0;i<list.size();++i){
                System.out.print(list.get(i));
                System.out.print(" ");
            }
            Deque<Integer> temp2 = new LinkedList<>(stack);
            while(!temp2.isEmpty()){
                System.out.print(temp2.removeLast());
                System.out.print(" ");
            }
            System.out.println();
            return;
        }
        //首先stack入栈
        stack.offer(a[pos]);
        Deque<Integer> tempStack = new LinkedList<>(stack);
        while(!tempStack.isEmpty()){
            list.add(tempStack.removeLast());
            dfs(a,pos+1,n,tempStack,list);
        }
    }
}
