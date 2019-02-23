package 研究生复试;
import 研究生复试.QuickSort;
public class BinarySearch {
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int a[] = {1,5,6,9,4,2,3,7,8};
		sort(a,0,a.length-1);
		System.out.println(search(0,a.length-1,a,7));
	}
	public static int search(int start,int end,int a[],int key){
		int mid = start;
		while(start<=end){
			mid = start + (end-start)/2;
			if(key == a[mid]){
				return mid;
			}else if(key<a[mid]){
				end = mid - 1;
			}else{
				start = mid +1;
			}
		}
		return -1;
	}
	public static void sort(int a[],int start,int end){
		if(start>end) return;
		int partition = divide(a,start,end);
		sort(a,start,partition-1);
		sort(a,partition+1,end);
	}
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
}
