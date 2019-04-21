package 研究生复试;
public class Permutation {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int a[] = {1,2};
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
			//举一个简单的例子来理解，对于ABCD而言，当k = 0时，先取A，然后求f(1,a),即剩下的数据有多少种排列，然后循环一下取i = 1，把A和B换一下
			//就变成取了B，然后算ACD有多少种排列了
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
