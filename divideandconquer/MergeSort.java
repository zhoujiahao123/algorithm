package algorithm.divideandconquer;

/**
 * �鲢�㷨��
 * �ȵݹ�ֽ�����
 * �ٺϲ���������
 */
public class MergeSort {


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        //�����������
        int number = 10000;
        int temp[] = new int[number];
        int a[] = new int[number];
        for (int i = 0; i < number; i++) {
            a[i] = (int) (Math.random() * number);
        }
        mergeSort.mergeSort(0, a.length - 1, a, temp);
        for (int i = 0; i < number; i++) {
            System.out.print(a[i] + "->");
        }
    }


    public void mergeSort(int first, int end, int a[], int temp[]) {
        if (first < end) {
            int mid = (first + end) / 2;
            mergeSort(first, mid, a, temp);
            mergeSort(mid + 1, end, a, temp);
            mergeArray(a, first, mid, end, temp);
        }
    }

    /**
     * �ϲ��������飬�Ƚ���������ĵ�һ������˭С��ȡ˭��Ȼ���ٴ�������ȥ���Ѿ�ѡ���˵ģ�Ȼ���ٽ��бȽϡ�
     * ���ĳ������Ϊ�գ���ֱ��ȡ��һ���������
     *
     * @param a
     * @param first
     * @param mid
     * @param end
     * @param temp
     */
    public void mergeArray(int a[], int first, int mid, int end, int temp[]) {
        //���кϲ�����������Ϊa[first .. mid]  a[mid+1 end]
        int i = first, m = mid, j = mid + 1, n = end, k = 0;
        //�Ȱ�����������ÿ��С��������һ����ʱ������
        while (i <= m && j <= n) {
            if (a[i] < a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }
        while (i <= m) {
            temp[k++] = a[i++];
        }
        while (j <= n) {
            temp[k++] = a[j++];
        }
        for (i = 0; i < k; i++) {
            //ע�������Ǵ�first + i ��ʼ��
            a[first + i] = temp[i];
        }
    }
}
