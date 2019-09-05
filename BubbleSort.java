package algorithm;

public class BubbleSort {
    public static void main(String[] args) {
        int a[] = {1,5,6,7,8,9,1,2,2,4};
        sort(a);

    }
    public static void sort(int a[]){
        int len = a.length;
        boolean flag = true;//表示还需要进行排序
        for(int i = 0;i<len&&flag;i++){
            flag = false;
            for(int j = 0;j< len -i -1;j++){
                if(a[j]>a[j+1]){
                    flag = true;
                    a[j] = a[j]^a[j+1];
                    a[j+1] = a[j]^a[j+1];
                    a[j] = a[j]^a[j+1];
                }
            }
        }
    }
}
