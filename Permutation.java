package 研究生复试;
public class Permutation {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int a[] = {1,2,3,4};
		f(0,a);
	}
	public static void f(int k ,int a[]){
		if(k == a.length){
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
			a[i] = a[k];
			a[k] = temp;
		}
	}
}
