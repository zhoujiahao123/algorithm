package algorithm.dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * ����
 *
 * @param <Key>
 */
public class MaxHeap<Key extends Comparable<Key>> {
    private List<Key> elements;

    public MaxHeap() {
        elements = new ArrayList<>();
        //�Ƚ���һ������0�����������Ĳ���������ʹ��/2ֱ�ӷ��ʵ����ڵ�
        elements.add((Key) Integer.valueOf(0));
    }

    /**
     * ����һ�����ݣ�Ȼ�����ϸ���
     */
    public void insertElement(Key key) {
        elements.add(key);
        swim();
    }

    /**
     * ɾ��һ���������ؽ����
     * �����о��ǶѶ�����
     */
    public Key deleteElement() {
        //������һ���ڵ������һ���ڵ�
        swap(1, elements.size() - 1);
        Key result = elements.remove(elements.size() - 1);
        //Ȼ����Ҫ����С�����³�
        sink();
        return result;
    }

    /**
     * �³�����
     */
    public void sink() {
        int index = 1;
        int size = elements.size();
        while (index * 2 + 1 < size) {
            Key left = elements.get(index * 2);
            Key right = elements.get(index * 2 + 1);
            int older = right.compareTo(left) < 0 ? index * 2 : index * 2 + 1;
            if (elements.get(index).compareTo(elements.get(older)) < 0) {
                //�������С����ô����λ��
                swap(index, older);
                index = older;
            } else {
                break;
            }
        }
        if (index * 2 < size) {
            if (elements.get(index).compareTo(elements.get(index * 2)) < 0) {
                //�������С����ô����λ��
                swap(index, index * 2);
            }
        }
    }

    /**
     * �ϸ�����
     */
    public void swim() {
        int index = elements.size() - 1;
        //ע������Ѿ��ǵ�һ���ˣ���ô����Ҫ�ٱȽ���
        while (index > 1 && elements.get(index / 2).compareTo(elements.get(index)) < 0) {
            //����ӽڵ�С�ڸ��ڵ�
            swap(index, index / 2);
            index = index / 2;
        }
    }

    /**
     * ����������
     *
     * @param index1
     * @param index2
     */
    public void swap(int index1, int index2) {
        Key temp = elements.get(index1);
        elements.set(index1, elements.get(index2));
        elements.set(index2, temp);
    }

    public static void main(String[] args) {
        //����
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        for (int i = 10; i < 20; ++i) {
            maxHeap.insertElement(i);
        }
        System.out.println(maxHeap.deleteElement());
        System.out.println(maxHeap.deleteElement());
        System.out.println(maxHeap.deleteElement());
        maxHeap.insertElement(20);
        maxHeap.insertElement(30);
        maxHeap.insertElement(40);
        System.out.println(maxHeap.deleteElement());
        System.out.println(maxHeap.deleteElement());
        System.out.println(maxHeap.deleteElement());
        maxHeap.insertElement(50);
        System.out.println(maxHeap.deleteElement());
        System.out.println(maxHeap.deleteElement());
        System.out.println(maxHeap.deleteElement());
    }
}
