package �о�������;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Permutation {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Calendar c = Calendar.getInstance();
		c.set(1997,11,30);
		Date d = c.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
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
			//��Ҫ���ݣ���Ϊ��A��B������ʱ����һ��ѭ��Ӧ����A��C���������ǵ�ǰ��B��C
			a[i] = a[k];
			a[k] = temp;
		}
	}
}
