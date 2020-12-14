package algorithm.Set.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Vector;

public class ArrayListTest {
    
        public static void main(String[] args) {
            ArrayList list = new ArrayList();

            //�������int���͵�linkedList
            LinkedList<Integer> linkedList = new LinkedList<>();
            /************************** linkedList�Ļ������� ************************/
            linkedList.addFirst(0); // ���Ԫ�ص��б�ͷ

            linkedList.add(1); // ���б��β���Ԫ��
            linkedList.add(2, 2); // ��ָ��λ�����Ԫ��
            linkedList.addLast(3); // ���Ԫ�ص��б��β
            System.out.println("LinkedList��ֱ������ģ�: " + linkedList);
            System.out.println("getFirst()��õ�һ��Ԫ��: " + linkedList.getFirst()); // ���ش��б�ĵ�һ��Ԫ��
            System.out.println("getLast()��õ����һ��Ԫ��: " + linkedList.getLast()); // ���ش��б�����һ��Ԫ��
            System.out.println("removeFirst()ɾ����һ��Ԫ�ز�����: " + linkedList.removeFirst()); // �Ƴ������ش��б�ĵ�һ��Ԫ��
            System.out.println("removeLast()ɾ�����һ��Ԫ�ز�����: " + linkedList.removeLast()); // �Ƴ������ش��б�����һ��Ԫ��
            System.out.println("After remove:" + linkedList);
            System.out.println("contains()�����ж��б��Ƿ����1���Ԫ��:" + linkedList.contains(1)); // �жϴ��б����ָ��Ԫ�أ�����ǣ��򷵻�true
            System.out.println("��linkedList�Ĵ�С : " + linkedList.size()); // ���ش��б��Ԫ�ظ���
            /************************** Search���� ************************/
            System.out.println("-----------------------------------------");
            linkedList.add(3);
            System.out.println("indexOf(3): " + linkedList.indexOf(3)); // ���ش��б����״γ��ֵ�ָ��Ԫ�ص�����
            System.out.println("lastIndexOf(3): " + linkedList.lastIndexOf(3));// ���ش��б��������ֵ�ָ��Ԫ�ص�����

            /************************** Queue���� ************************/
            System.out.println("-----------------------------------------");
            System.out.println("peek(): " + linkedList.peek()); // ��ȡ�����Ƴ����б��ͷ
            System.out.println("element(): " + linkedList.element()); // ��ȡ�����Ƴ����б��ͷ
            linkedList.poll(); // ��ȡ���Ƴ����б��ͷ
            System.out.println("After poll():" + linkedList);
            linkedList.remove();
            System.out.println("After remove():" + linkedList); // ��ȡ���Ƴ����б��ͷ
            linkedList.offer(4);
            System.out.println("After offer(4):" + linkedList); // ��ָ��Ԫ����ӵ����б��ĩβ
        }


}
