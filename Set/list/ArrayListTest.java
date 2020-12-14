package algorithm.Set.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Vector;

public class ArrayListTest {
    
        public static void main(String[] args) {
            ArrayList list = new ArrayList();

            //创建存放int类型的linkedList
            LinkedList<Integer> linkedList = new LinkedList<>();
            /************************** linkedList的基本操作 ************************/
            linkedList.addFirst(0); // 添加元素到列表开头

            linkedList.add(1); // 在列表结尾添加元素
            linkedList.add(2, 2); // 在指定位置添加元素
            linkedList.addLast(3); // 添加元素到列表结尾
            System.out.println("LinkedList（直接输出的）: " + linkedList);
            System.out.println("getFirst()获得第一个元素: " + linkedList.getFirst()); // 返回此列表的第一个元素
            System.out.println("getLast()获得第最后一个元素: " + linkedList.getLast()); // 返回此列表的最后一个元素
            System.out.println("removeFirst()删除第一个元素并返回: " + linkedList.removeFirst()); // 移除并返回此列表的第一个元素
            System.out.println("removeLast()删除最后一个元素并返回: " + linkedList.removeLast()); // 移除并返回此列表的最后一个元素
            System.out.println("After remove:" + linkedList);
            System.out.println("contains()方法判断列表是否包含1这个元素:" + linkedList.contains(1)); // 判断此列表包含指定元素，如果是，则返回true
            System.out.println("该linkedList的大小 : " + linkedList.size()); // 返回此列表的元素个数
            /************************** Search操作 ************************/
            System.out.println("-----------------------------------------");
            linkedList.add(3);
            System.out.println("indexOf(3): " + linkedList.indexOf(3)); // 返回此列表中首次出现的指定元素的索引
            System.out.println("lastIndexOf(3): " + linkedList.lastIndexOf(3));// 返回此列表中最后出现的指定元素的索引

            /************************** Queue操作 ************************/
            System.out.println("-----------------------------------------");
            System.out.println("peek(): " + linkedList.peek()); // 获取但不移除此列表的头
            System.out.println("element(): " + linkedList.element()); // 获取但不移除此列表的头
            linkedList.poll(); // 获取并移除此列表的头
            System.out.println("After poll():" + linkedList);
            linkedList.remove();
            System.out.println("After remove():" + linkedList); // 获取并移除此列表的头
            linkedList.offer(4);
            System.out.println("After offer(4):" + linkedList); // 将指定元素添加到此列表的末尾
        }


}
