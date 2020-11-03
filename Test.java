package 研究生复试;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;

public class Test {
	public static void main(String[] args) {
		String s = "25525511135";
		System.out.println(8 + "abc" + (1 + 2));
		System.out.println("abcd".substring(1,3).indexOf("a"));
		int x = 'a';
//		System.out.println(s.substring(0,1));
//		// TODO 自动生成的方法存根
////		int a[] = {7,8,4,5,9,2,1,3,6};
////		int b[] = {0,1,2,3};
////		int c[] = {3,3,3};
////		combination(c,0,3,"");
////		quickSort(a,0,a.length-1);
////		System.out.println(binarySearch(a,0,a.length-1,9));
////		permutation(b,0);
//		double i1 = 1/3;
//		double i2 = 1/3;
//		System.out.println(i1 == i2);
//		String s1 = "123";
//		System.out.println(System.identityHashCode(s1));
//		s1 += "45";
//		System.out.println(System.identityHashCode(s1));
//		final char[] c = {'1','2','3'};
//		System.out.println(System.identityHashCode(c));
//		System.arraycopy(c,0,c,0,2);
//		System.out.println(System.identityHashCode(c));



	}
	/**
	 * 选择排序
	 * @param a
	 */
	public static void selectionSort(int a[]){
		int index = 0;
		for(int  i = 0;i<a.length-1;i++){
			for(int j = i+1;j<a.length;j++){
				if(a[index]>a[j]) index = j;
			}
			int temp = a[i];
			a[i] = a[index];
			a[index] = temp;
		}
	}
	/**
	 * 快速排序
	 * @param a
	 * @param start
	 * @param end
	 */
	public static void quickSort(int a[],int start,int end){
		if(start>=end){
			return ;
		}else{
			int partition = divide(a,start,end);
			quickSort(a,start,partition-1);
			quickSort(a,partition+1,end);
		}
	}
	public static int divide(int a[],int start,int end){
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
		return end;
	}
	/**
	 * 二分查找
	 * @param a
	 * @param start
	 * @param end
	 * @param key
	 * @return
	 */
	public static int binarySearch(int a[],int start,int end,int key){
		int mid = start;
		//这里的小于等于要注意
		while(start<=end){
			mid = start + (end-start)/2;
			if(key==a[mid]){
				return mid;
			}else if(key<a[mid]){
				end = mid - 1;
			}else{
				start= mid + 1;
			}
		}
		return -1;
	}
	/**
	 * 全排列问题
	 * @param a
	 * @param k
	 */
	public static void permutation(int a[],int k){
		if(k == a.length){
			for(int i = 0;i<a.length;i++){
				String s = "";
				s += (char)(a[i]+'A'); 
				System.out.print(s);
			}
			System.out.println();
		}
		for(int i = k;i<a.length;i++){
			int temp = a[k];
			a[k] = a[i];
			a[i] = temp;
			permutation(a,k+1);
			a[i] = a[k];
			a[k] = temp;
		}
	}
	/**
	 * 组合问题
	 * @param a
	 * @param k
	 * @param n
	 * @param s
	 */
	public static void combination(int a[],int k,int n,String s){
		if(k == a.length){
			if(n == 0){
				System.out.println(s);
			}
			return ;
		}
		//这里的小于等于要注意
		for(int i = 0;i<=a[k];i++){
			combination(a,k+1,n-i,s);
			s = s + (char)('A'+k);
		}
	}
}
