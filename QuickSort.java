package 研究生复试;

/**
 * 即便是有序数组仍然要进行这么多次的递归。
 */
public class QuickSort {

	public static int divide(int a[] , int start,int end){
		while(start<end){
			int base = a[end];
			while(start<end&&a[start]<=base) start++;
			if(start<end){
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
				end--;
			}
			while(start<end&&a[end]>=base) end--;
			if(start<end){
				int temp = a[end];
				a[end] = a[start];
				a[start] = temp;
				start++;
			}
		}

		return start;
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int a[] = {7,8,3,4,9,6,1,2,5};
		sort(a,0,8);
		for(int i = 0 ;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
	public static void sort(int a[],int start,int end){
		if(start>=end) return;
		int partition = divide(a,start,end);
		sort(a,start,partition-1);
		sort(a,partition+1,end);
	}

}
