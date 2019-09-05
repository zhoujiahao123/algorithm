package 研究生复试;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Permutation {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Calendar c = Calendar.getInstance();
		c.set(1997,11,30);
		Date d = c.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		String s = sdf.format(d);
		System.out.println(s);
	}
	public static void f(int k ,int a[]){
		if(k == a.length-1){
			for(int i = 0;i<a.length;i++)
				System.out.print(a[i]);
			System.out.println();
			return ;
		}
		for(int i = k;i<a.length;i++){
			int temp = a[k];
			a[k] = a[i];
			a[i] = temp;
			f(k+1,a);
			//需要回溯，因为当A与B交换的时候，下一个循环应当是A与C交换而不是当前的B与C
			a[i] = a[k];
			a[k] = temp;
		}
	}
}
