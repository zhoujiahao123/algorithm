package algorithm.dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大堆
 *
 * @param <Key>
 */
public class MaxHeap<Key extends Comparable<Key>> {
    private List<Key> elements;

    public MaxHeap() {
        elements = new ArrayList<>();
        //先将第一个数置0，这样后续的操作都可以使用/2直接访问到父节点
        elements.add((Key) Integer.valueOf(0));
    }

    /**
     * 插入一个数据，然后向上浮动
     */
    public void insertElement(Key key) {
        elements.add(key);
        swim();
    }

    /**
     * 删除一个数并返回结果，
     * 最大堆中就是堆顶的数
     */
    public Key deleteElement() {
        //交换第一个节点与最后一个节点
        swap(1, elements.size() - 1);
        Key result = elements.remove(elements.size() - 1);
        //然后需要把最小的数下沉
        sink();
        return result;
    }

    /**
     * 下沉操作
     */
    public void sink() {
        int index = 1;
        int size = elements.size();
        while (index * 2 + 1 < size) {
            Key left = elements.get(index * 2);
            Key right = elements.get(index * 2 + 1);
            int older = right.compareTo(left) < 0 ? index * 2 : index * 2 + 1;
            if (elements.get(index).compareTo(elements.get(older)) < 0) {
                //如果比它小，那么交换位置
                swap(index, older);
                index = older;
            } else {
                break;
            }
        }
        if (index * 2 < size) {
            if (elements.get(index).compareTo(elements.get(index * 2)) < 0) {
                //如果比它小，那么交换位置
                swap(index, index * 2);
            }
        }
    }

    /**
     * 上浮操作
     */
    public void swim() {
        int index = elements.size() - 1;
        //注意如果已经是第一层了，那么不需要再比较了
        while (index > 1 && elements.get(index / 2).compareTo(elements.get(index)) < 0) {
            //如果子节点小于父节点
            swap(index, index / 2);
            index = index / 2;
        }
    }

    /**
     * 交换两个数
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
        //测试
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
